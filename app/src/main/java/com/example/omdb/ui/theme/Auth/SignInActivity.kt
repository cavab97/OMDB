package com.example.omdb.ui.theme.Auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
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
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
                }

                else -> {}
            }
        })
        super.onActivityCreated(savedInstanceState)
        // write logic
        binding.loginButtonId.setOnClickListener {
            val email =binding.emailValue.text.toString().trim()
            val password=binding.editTextTextPassword.text.toString().trim()

            //@todo add input validation
            viewModel.login(email, password)
        }
    }
    override fun getViewModel()=AuthViewModel::class.java


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )=ActivityLoginBinding.inflate(inflater,container,false)

    override fun getFragmentRepository()= AuthRepository(remoteDataSource.buildAuthApi(AuthApi::class.java))


}