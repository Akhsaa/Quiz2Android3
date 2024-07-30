package com.example.quizpemro3

import retrofit2.Response
import retrofit2.http.GET

interface LocationService {
    @GET("/timezone?apiKey=aaddf3cc669e494f870272c1a5843c03")
    suspend fun getLocation() : Response<Location>

}