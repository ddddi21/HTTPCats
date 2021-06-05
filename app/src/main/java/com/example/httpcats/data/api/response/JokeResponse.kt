package com.example.httpcats.data.api.response

import com.google.gson.annotations.SerializedName

data class JokeResponse(
    @SerializedName("id")
    var id:Int,
    @SerializedName("type")
    var type: String,
    @SerializedName("setup")
    var setup: String,
    @SerializedName("punchline")
    var punchline: String
)