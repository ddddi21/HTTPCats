package com.example.httpcats.data.api

import com.example.httpcats.BuildConfig
import com.example.httpcats.data.response.JokeResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiFactory {
    private const val QUERY_API_KEY = "appid"

//    private val apiKeyInterceptor = Interceptor { chain ->
//        val original = chain.request()
//        original.url().newBuilder()
//            .addQueryParameter(
//                QUERY_API_KEY,
//                BuildConfig.API_KEY
//            )
//            .build()
//            .let {
//                chain.proceed(
//                    original.newBuilder().url(it).build()
//                )
//            }
//    }

    private val client by lazy {
        OkHttpClient.Builder()
//            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(LoggingInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.API_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


     val jokeApi: JokeApi by lazy {
        retrofit.create(JokeApi::class.java)
    }
}