package com.example.httpcats.domain.repository

import androidx.lifecycle.MutableLiveData
import com.example.httpcats.data.api.response.JokeResponse
import com.example.httpcats.presenter.model.Joke

interface JokeRepository {
    suspend fun getRandomJoke(joke: MutableLiveData<Joke>): JokeResponse

    suspend fun getTenJokes(jokes:MutableList<Joke>, jokesList:MutableLiveData<List<Joke>>): List<JokeResponse>

    suspend fun getITJoke(jokes:MutableList<Joke>,jokesList: MutableLiveData<List<Joke>>): List<JokeResponse>

    suspend fun getTenITJoke(jokes:MutableList<Joke>, jokesList:MutableLiveData<List<Joke>>): List<JokeResponse>
}