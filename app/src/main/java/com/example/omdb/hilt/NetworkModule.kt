package com.example.omdb.hilt

//import com.example.omdb.ProductsServices
//import com.example.omdb.ProductsServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    public fun providesOkHttpClient(): OkHttpClient {
        val duration = java.time.Duration.ofSeconds(30)
        return OkHttpClient.Builder()
            .connectTimeout(duration)
            .readTimeout(duration)
            .writeTimeout(duration)
            .build()
    }

//    @Provides
//    @Singleton
//    fun providesProductsService(retrofit: Retrofit): ProductsServices {
//        return retrofit.create(ProductsServices::class.java)
//    }
//    @Provides
//    @Singleton
//    fun providesAuthService(retrofit: Retrofit): AuthService {
//        return retrofit.create(AuthService::class.java)
//    }

}