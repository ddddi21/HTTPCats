package com.example.httpcats.data.api.impl

import androidx.lifecycle.MutableLiveData
import com.example.httpcats.data.api.request.JokeApi
import com.example.httpcats.data.api.response.JokeResponse
import com.example.httpcats.domain.repository.JokeRepository
import com.example.httpcats.presenter.model.Joke
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class JokeRepositoryImpl(
    private val jokeApi: JokeApi
): JokeRepository {
    override suspend fun getRandomJoke(joke: MutableLiveData<Joke>): JokeResponse {
        var response = jokeApi.getJoke()
        val newJoke  = Joke(response.id, response.setup,response.punchline)
        joke.value = newJoke
        return response
    }

    override suspend fun getTenJokes(
        jokes: MutableList<Joke>,
        jokesList: MutableLiveData<List<Joke>>
    ): List<JokeResponse> {
        var response =  jokeApi.getTenJokes()
        for (joke in response){
            val newJoke  = Joke(joke.id, joke.setup,joke.punchline)
            jokes.add(newJoke)
        }
        jokesList.value = jokes
        return response
    }

    override suspend fun getITJoke(jokes:MutableList<Joke>,jokesList: MutableLiveData<List<Joke>>
    ): List<JokeResponse> {
        var response =  jokeApi.getITMeme()
        for (joke in response){
            val newJoke  = Joke(joke.id, joke.setup,joke.punchline)
            jokes.add(newJoke)
        }
        jokesList.value = jokes
        return response
    }

    override suspend fun getTenITJoke(
        jokes: MutableList<Joke>,
        jokesList: MutableLiveData<List<Joke>>
    ): List<JokeResponse> {
        var response =  jokeApi.getTenITMemes()
        for (joke in response){
            val newJoke  = Joke(joke.id, joke.setup,joke.punchline)
            jokes.add(newJoke)
        }
        jokesList.value = jokes
        return response
    }
//    override suspend fun getRandomJoke(): JokeResponse {
//       return jokeApi.getJoke()
//    }
//
//    override suspend fun getTenJokes(): List<JokeResponse> {
//        return jokeApi.getTenJokes()
//    }
//
//    override suspend fun getITJoke(): List<JokeResponse> {
//        return jokeApi.getITMeme()
//    }
//
//    override suspend fun getTenITJoke(): List<JokeResponse> {
//        return jokeApi.getTenITMemes()
//    }
}