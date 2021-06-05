package com.example.httpcats.data.api.request

import com.example.httpcats.data.api.response.BoredResponse
import io.reactivex.Single
import retrofit2.http.GET

interface BoredApi {

    @GET("api/activity/")
    fun getRandomActivity() : Single<BoredResponse>
}