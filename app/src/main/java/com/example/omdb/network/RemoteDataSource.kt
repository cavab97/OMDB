package com.example.omdb.network

import com.example.omdb.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
class RemoteDataSource {

    companion object{
        private const val BASE_URL="https://www.omdbapi.com/"
        private const val BASE_LOGIN_URL="https://expressbackend-production.up.railway.app/api/"
//    private const val BASE_LOGIN_URL="http://localhost:7070/api/"
    }
    fun <Api>buildApi( api:Class<Api>): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL).client(OkHttpClient.Builder().also { client->
//                if(c)
                if(BuildConfig.DEBUG){
                    val logging=HttpLoggingInterceptor();
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(logging)
                }

            }.build())
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(api);
    }
    fun <Api>buildAuthApi( api:Class<Api>): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_LOGIN_URL).client(OkHttpClient.Builder().also { client->
//                if(c)
                if(BuildConfig.DEBUG){
                    val logging=HttpLoggingInterceptor();
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(logging)
                }

            }.build())
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(api);
    }
}

