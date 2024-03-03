package com.example.omdb.repository

import com.example.omdb.network.AuthApi

class MovieRepository(
    private val api:AuthApi
):BaseRepository() {
    suspend fun login(
        email:String,
        password:String
    )=safeApiCall{
        api.login(email,password)
    }

}

