package com.example.httpcats.presenter.single

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.httpcats.data.api.request.JokeApi
import com.example.httpcats.data.api.response.JokeResponse
import com.example.httpcats.domain.JokeInteractor
import com.example.httpcats.presenter.model.Joke
import kotlinx.coroutines.launch
import javax.inject.Inject

class SingleJokeVm @Inject constructor(
    var jokeInteractor: JokeInteractor
): ViewModel() {
    var setUp = MutableLiveData<String>()
    var punchline = MutableLiveData<String>()
    var joke = MutableLiveData<Joke>()
    var isVisible = MutableLiveData(true)

    var jokes: MutableList<Joke> = mutableListOf()
    var jokesList=  MutableLiveData<List<Joke>>()

    var jokeResponse: JokeResponse ?= null

    fun loadRandomJoke() {
        viewModelScope.launch {
            try {
            jokeInteractor.getJoke(joke)
            setUp.value = joke.value?.setUp
            punchline.value = joke.value?.punchline
                isVisible.value = true
            } catch (throwable: Throwable) {
                Log.d("find bug", throwable.message.toString())
            } finally {
                isVisible.value = false
            }
        }
    }

    fun loadITJoke() {
        viewModelScope.launch {
            try {
            jokeInteractor.getItJoke(jokes, jokesList)
            setUp.value = jokesList.value?.get(0)?.setUp
            punchline.value = jokesList.value?.get(0)?.setUp
                isVisible.value = true
            } catch (throwable: Throwable) {
                Log.d("find bug", throwable.message.toString())
            } finally {
                isVisible.value = false
            }
        }
    }

    fun loadRandom(){
        val id = (1..20).random()
        if(id in 1..10){
            loadRandomJoke()
        } else{
            loadITJoke()
        }
    }

}