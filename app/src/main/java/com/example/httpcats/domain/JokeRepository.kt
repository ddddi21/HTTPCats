package com.example.httpcats.domain

import com.example.httpcats.data.response.JokeResponse

interface JokeRepository {
    suspend fun getRandomJoke(): JokeResponse

    suspend fun getTenJokes(): List<JokeResponse>

    suspend fun getITJoke(): List<JokeResponse>

    suspend fun getTenITJoke(): List<JokeResponse>
}