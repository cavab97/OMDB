package com.example.omdb.ui.theme.Auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.omdb.databinding.ActivityLoginBinding
import com.example.omdb.network.AuthApi
import com.example.omdb.repository.AuthRepository
import com.example.omdb.ui.theme.base.BaseFragment

//import com.google.firebase.auth.FirebaseAuth

class SignInActivity : BaseFragment<AuthViewModel,ActivityLoginBinding,AuthRepository>() {
//    override fun getViewModel(): Class<AuthViewModel> {
//        TODO("Not yet implemented")
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // write logic
        binding.loginButtonId.setOnClickListener {
            val email =binding.emailValue.text.toString().trim()
            val password=binding.editTextTextPassword.text.toString().trim()
        }
    }
    override fun getViewModel()=AuthViewModel::class.java


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )=ActivityLoginBinding.inflate(inflater,container,false)

    override fun getFragmentRepository()= AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))


}