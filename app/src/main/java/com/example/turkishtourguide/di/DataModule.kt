package com.example.turkishtourguide.di

import com.example.turkishtourguide.data.network.RetrofitClient
import com.example.turkishtourguide.data.network.api.NewsApiService
import com.example.turkishtourguide.data.repository.NewsRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single { provideRetrofit() }

    single { provideSpaceXApiService(get()) }
    single { NewsRepository(get()) }
}

fun provideRetrofit(): Retrofit = RetrofitClient.getRetrofit()

fun provideSpaceXApiService(
        retrofit: Retrofit
): NewsApiService = retrofit.create(NewsApiService::class.java)