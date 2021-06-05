package com.example.httpcats.data.api.impl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.httpcats.data.api.request.BoredApi
import com.example.httpcats.domain.repository.ApiActivityRepository
import com.example.httpcats.presenter.model.ActivityFromApi
import io.reactivex.schedulers.Schedulers

class ApiActivityRepositoryImpl(
    private var boredApi: BoredApi
) : ApiActivityRepository {

    override fun getActivity(newActivity: MutableLiveData<ActivityFromApi>) {
        boredApi.getRandomActivity()
            .subscribeOn(Schedulers.io())
            .blockingGet()
            .also { response ->
                val newNewActivityFromApi = ActivityFromApi(
                    "", 0.0,
                    "", 0, 0.0, "", ""
                )
                newNewActivityFromApi.apply {
                    activity = response.activity
                    accessibility = response.accessibility
                    type = response.type
                    participants = response.participants
                    price = response.price
                    key = response.key
                    link = response.link
                }
                newActivity.value = newNewActivityFromApi
                Log.d("find bug", newNewActivityFromApi.toString())
            }
    }
}