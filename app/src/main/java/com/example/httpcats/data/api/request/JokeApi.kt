package com.example.httpcats.data.api.request

import com.example.httpcats.data.api.response.JokeResponse
import retrofit2.http.GET

interface JokeApi {
    @GET("random")
    suspend fun getJoke(): JokeResponse

    @GET("ten")
    suspend fun getTenJokes():List<JokeResponse>

    @GET("programming/random")
    suspend fun getITMeme():List<JokeResponse> // оно тоже почему то листом приходит

    @GET("programming/ten")
    suspend fun getTenITMemes():List<JokeResponse>
}