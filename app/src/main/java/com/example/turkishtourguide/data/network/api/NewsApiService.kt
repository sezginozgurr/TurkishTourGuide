package com.example.turkishtourguide.data.network.api

import com.example.turkishtourguide.data.model.Rocket
import com.example.turkishtourguide.data.model.Rocket2
import retrofit2.Response
import retrofit2.http.GET

interface NewsApiService {
    @GET("rockets")
    suspend fun getRockets(): List<Rocket>

    @GET("rockets")
    suspend fun getRockets2(): Response<List<Rocket2>>
}