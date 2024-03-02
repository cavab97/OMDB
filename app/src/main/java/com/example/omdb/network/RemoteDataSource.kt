package com.example.omdb.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RemoteDataSource {

    companion object{
        private const val BASE_URL="https://www.omdbapi.com/"

    }
    fun <Api>buildApi( api:Class<Api>): Api {
        return Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(api);
    }
}

