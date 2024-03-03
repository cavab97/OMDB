package com.example.omdb.network


import com.example.omdb.BuildConfig
import com.example.omdb.ui.theme.movielist.MovieDetailsModel
import com.example.omdb.ui.theme.movielist.MoviesPageModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL="https://www.omdbapi.com/"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).client(
    OkHttpClient.Builder().also { client->
    if(BuildConfig.DEBUG){
        val logging= HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        client.addInterceptor(logging)
    }
}.build()).addConverterFactory(MoshiConverterFactory.create()).build()
interface MoviesAuthApi {

    @GET("?apikey=6fc87060&s=Marvel&type=movie")
     fun getAllData(): Call<MoviesPageModel>
    @GET("?apikey=6fc87060&i=tt4154664")
    fun getDetails(): Call<MovieDetailsModel>


}

object Api {
    val retrofitService: MoviesAuthApi by lazy{retrofit.create(MoviesAuthApi::class.java)}
}

