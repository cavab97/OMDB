package com.example.omdb.ui.theme.Auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.omdb.R
import com.example.omdb.databinding.ActivityLoginBinding
import com.example.omdb.network.AuthApi
import com.example.omdb.network.Resource
import com.example.omdb.repository.AuthRepository
import com.example.omdb.ui.theme.base.BaseFragment

//import com.google.firebase.auth.FirebaseAuth

class SignInActivity : BaseFragment<AuthViewModel,ActivityLoginBinding,AuthRepository>() {
//    override fun getViewModel(): Class<AuthViewModel> {
//        TODO("Not yet implemented")
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {

            when(it){
                is Resource.Success->{
                    Toast.makeText(requireContext(),it.toString(),Toast.LENGTH_LONG).show()
                }

                is Resource.Failure->{
                    Toast.makeText(requireContext(), "Information Error", Toast.LENGTH_LONG).show()
                }

                else -> {}
            }
        })
        super.onActivityCreated(savedInstanceState)
        // write logic
        binding.loginButtonId.setOnClickListener {
            val email =binding.emailValue.text.toString().trim()
            val password=binding.editTextTextPassword.text.toString().trim()

            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(requireContext(),"Information was not fill in Properly",Toast.LENGTH_LONG).show()
            }else{
                if(email == "VVVBB" && password == "@bcd1234"){
                        findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)

                    Toast.makeText(requireContext(),"Successful Login",Toast.LENGTH_LONG).show()

                }else {
                    Toast.makeText(requireContext(),"Wrong User",Toast.LENGTH_LONG).show()
                }
            }
            //@todo add input validation
//            viewModel.login(email, password)

        }

        binding.signInBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
    override fun getViewModel()=AuthViewModel::class.java


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )=ActivityLoginBinding.inflate(inflater,container,false)

    override fun getFragmentRepository()= AuthRepository(remoteDataSource.buildAuthApi(AuthApi::class.java))


}