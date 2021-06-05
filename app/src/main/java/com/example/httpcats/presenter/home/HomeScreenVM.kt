package com.example.httpcats.presenter.home

import android.util.Log
import androidx.lifecycle.*
import com.example.httpcats.domain.repository.WordRepository
import javax.inject.Inject

class HomeScreenVM @Inject constructor(
    var wordRepository: WordRepository
) : ViewModel() {
    var words = MutableLiveData<String>()
//    val username = MutableLiveData("")


    init {
        wordRepository.getWords()
    }

    fun randomSupport() {
        val id = (1..20).random()
        Log.d("find bug", "random words #$id")
        val wordsFromRepo = wordRepository.getWordById(id)
        if (wordsFromRepo != null) {
            words.value = wordsFromRepo.text
        } else {
            words.value = "Have a nice day!"
        }
    }
}