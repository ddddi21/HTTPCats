package com.example.httpcats.presenter.joke

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.httpcats.domain.JokeInteractor
import com.example.httpcats.presenter.model.Joke
import kotlinx.coroutines.launch
import javax.inject.Inject

class JokesVM @Inject constructor(
    var jokeInteractor: JokeInteractor
) : ViewModel() {
    val jokes: MutableList<Joke> = mutableListOf()
    val jokesList = MutableLiveData<List<Joke>>()
    var isVisible = MutableLiveData(true)


    var jokeAdapter = JokeAdapter(jokes)

    fun loadTenJoke() {
        viewModelScope.launch {
            try {
                jokes.removeAll(jokes)
                jokeInteractor.getTenJokes(jokes,jokesList)
                isVisible.value = true
            } catch (throwable: Throwable) {
                Log.d("find bug", throwable.message.toString())
            } finally {
                isVisible.value = false
            }
        }
    }

    fun loadTenItJoke() {
        viewModelScope.launch {
            try {
                jokes.removeAll(jokes)
                jokeInteractor.getTenITJoke(jokes, jokesList)
                isVisible.value = true
            } catch (throwable: Throwable) {
                Log.d("find bug", throwable.message.toString())
            } finally {
                isVisible.value = false
            }
        }
    }


}