package com.example.turkishtourguide.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.turkishtourguide.data.model.Rocket
import com.example.turkishtourguide.data.model.Rocket2
import com.example.turkishtourguide.data.repository.NewsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class MainViewModel(private val repository: NewsRepository) : ViewModel() {
    val rockets: ArrayList<Rocket> = arrayListOf()
    val rockets2: ArrayList<Response<List<Rocket2>>> = arrayListOf()

    fun getRockets() {
        viewModelScope.launch {
            val request1 = async {
                try {
                    delay(3000)
                    repeat(3) {
                        rockets.addAll(repository.getRockets())
                    }
                } catch (e: Exception) {
                    println("Network error :[")
                    return@async
                }
            }

            val request2 = async {
                try {
                    repeat(4) {
                        rockets2.add(repository.getRockets2())
                    }
                } catch (e: Exception) {
                    println("Network error :[")
                    return@async
                }
            }

            request2.await()
            request1.await()

        }
    }

    fun getRockets2() {
        runBlocking {
            delay(3000)
            val response: Response<List<Rocket2>> = try {
                repository.getRockets2()
            } catch (e: Exception) {
                println("Network error :[")
                return@runBlocking
            }

            if (response.code() == 200) {
                response.body()
            }
        }

        runBlocking {
            val rockets: List<Rocket> = try {
                repository.getRockets()
            } catch (e: Exception) {
                println("Network error :[")
                return@runBlocking
            }
        }
    }
}