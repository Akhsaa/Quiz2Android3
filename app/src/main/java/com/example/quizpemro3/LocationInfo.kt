package com.example.quizpemro3

import com.google.gson.annotations.SerializedName


data class LocationInfo(
    @SerializedName("country_code3")
    val country_code3: String,

    @SerializedName("country_name")
    val country_name: String,

    @SerializedName("city")
    val city: String,

    @SerializedName("latitude")
    val latitude: Float,

    @SerializedName("longitude")
    val longitude: Float
)
