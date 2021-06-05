package com.example.httpcats.domain

import androidx.lifecycle.MutableLiveData
import com.example.httpcats.domain.repository.ApiActivityRepository
import com.example.httpcats.presenter.model.ActivityFromApi
import javax.inject.Inject


class ApiActivityInteractor @Inject constructor(
    private var apiRepository: ApiActivityRepository
) {
    fun getSomeActivity(newActivity: MutableLiveData<ActivityFromApi>) {
        apiRepository.getActivity(newActivity)
    }

}