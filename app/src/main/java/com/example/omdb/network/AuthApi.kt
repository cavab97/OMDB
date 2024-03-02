package com.example.omdb.network

import com.example.omdb.response.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {
    @FormUrlEncoded
    @POST("login")
       suspend fun login(@Field("email") email: String, @Field("password") password: String): LoginResponse

}