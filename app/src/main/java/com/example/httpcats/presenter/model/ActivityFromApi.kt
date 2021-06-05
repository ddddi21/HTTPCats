package com.example.httpcats.presenter.model

data class ActivityFromApi(
    var activity: String,
    var accessibility: Double,
    var type: String,
    var participants: Int,
    var price: Double,
    var key: String,
    var link: String
)