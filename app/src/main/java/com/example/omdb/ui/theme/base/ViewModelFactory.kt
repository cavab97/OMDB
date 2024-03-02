package com.example.omdb.ui.theme.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.omdb.repository.AuthRepository
import com.example.omdb.repository.BaseRepository
import com.example.omdb.ui.theme.Auth.AuthViewModel

class ViewModelFactory(private val respository:BaseRepository):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return when{
            modelClass.isAssignableFrom(AuthViewModel::class.java)->
                AuthViewModel(respository as AuthRepository) as T
                else -> throw IllegalArgumentException("ViewModelClass Not Found")

        }
    }
}