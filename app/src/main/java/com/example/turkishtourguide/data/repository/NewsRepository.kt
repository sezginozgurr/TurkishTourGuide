package com.example.turkishtourguide.data.repository

import com.example.turkishtourguide.data.model.Rocket
import com.example.turkishtourguide.data.model.Rocket2
import com.example.turkishtourguide.data.network.api.NewsApiService
import retrofit2.Response

class NewsRepository(private val apiService: NewsApiService) {
    suspend fun getRockets(): List<Rocket> {
        return apiService.getRockets()
    }

    suspend fun getRockets2(): Response<List<Rocket2>> {
        return apiService.getRockets2()
    }
}