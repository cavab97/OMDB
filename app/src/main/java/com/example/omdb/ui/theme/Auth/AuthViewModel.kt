package com.example.omdb.ui.theme.Auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omdb.network.Resource
import com.example.omdb.repository.AuthRepository
import com.example.omdb.response.LoginResponse
import kotlinx.coroutines.launch

class AuthViewModel(private val repository:AuthRepository):ViewModel() {
    private val _loginResponse:MutableLiveData<Resource<LoginResponse>> = MutableLiveData() //Mutable data
    val loginResponse:LiveData<Resource<LoginResponse>> //Immutable data
        get()=_loginResponse
    fun login(email:String,password:String)=viewModelScope.launch {
        _loginResponse.value =repository.login(email, password)
    }

}