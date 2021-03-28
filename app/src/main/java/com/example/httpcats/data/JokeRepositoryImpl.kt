package com.example.httpcats.data

import com.example.httpcats.data.api.JokeApi
import com.example.httpcats.data.response.JokeResponse
import com.example.httpcats.domain.JokeRepository

class JokeRepositoryImpl(
    private val jokeApi: JokeApi
): JokeRepository {
    override suspend fun getRandomJoke(): JokeResponse {
        return jokeApi.getJoke()
    }

    override suspend fun getTenJokes(): List<JokeResponse> {
        return jokeApi.getTenJokes()
    }

    override suspend fun getITJoke(): List<JokeResponse> {
        return jokeApi.getITMeme()
    }

    override suspend fun getTenITJoke(): List<JokeResponse> {
        return jokeApi.getTenITMemes()
    }
}