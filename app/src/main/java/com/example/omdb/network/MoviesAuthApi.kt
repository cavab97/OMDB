package com.example.omdb.network


import android.content.pm.PackageManager
import retrofit2.Call
import retrofit2.http.GET


//private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()

interface MoviesAuthApi {

    @GET(".")
    fun getAllData(): Call<List<PackageManager.Property>>
}
object Api {
//    val retrofitService: MoviesAuthApi by lazy{retrofit.create(MoviesAuthApi::class.java)}
}