package com.example.httpcats.domain.repository

import androidx.lifecycle.MutableLiveData
import com.example.httpcats.presenter.model.ActivityFromApi


interface ApiActivityRepository {

    fun getActivity(newActivity: MutableLiveData<ActivityFromApi>)
}