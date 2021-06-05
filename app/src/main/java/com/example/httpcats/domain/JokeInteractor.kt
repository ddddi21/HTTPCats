package com.example.httpcats.domain

import androidx.lifecycle.MutableLiveData
import com.example.httpcats.domain.repository.JokeRepository
import com.example.httpcats.presenter.model.Joke
import javax.inject.Inject

class JokeInteractor @Inject constructor(
    private var jokeRepository: JokeRepository
) {
    suspend fun getJoke(joke: MutableLiveData<Joke>) {
        jokeRepository.getRandomJoke(joke)
    }

    suspend fun getTenJokes(jokes:MutableList<Joke>, jokesList:MutableLiveData<List<Joke>>){
        jokeRepository.getTenJokes(jokes, jokesList)
    }

    suspend fun getItJoke(jokes:MutableList<Joke>,jokesList: MutableLiveData<List<Joke>>){
        jokeRepository.getITJoke(jokes,jokesList)
    }

    suspend fun getTenITJoke(jokes:MutableList<Joke>, jokesList:MutableLiveData<List<Joke>>){
        jokeRepository.getTenITJoke(jokes, jokesList)
    }
}