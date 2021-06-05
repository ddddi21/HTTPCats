package com.example.httpcats.data.api.factory

import com.example.httpcats.BuildConfig
import com.example.httpcats.data.api.LoggingInterceptor
import com.example.httpcats.data.api.request.JokeApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiFactoryForActivity {
    private const val QUERY_API_KEY = "appid"


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
            .baseUrl(BuildConfig.API_ENDPOINT_ACTIVITY)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val jokeApi: JokeApi by lazy {
        retrofit.create(JokeApi::class.java)
    }
}