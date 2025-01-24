package com.example.seekhoassignment.repository

import android.util.Log
import com.example.seekhoassignment.model.AnimeListResponse
import com.example.seekhoassignment.model.detail.AnimeDetailResponse
import com.example.seekhoassignment.networking.ApiService
import com.example.seekhoassignment.networking.RetrofitClient
import retrofit2.Response

class AnimeRepository  {
    private val retrofit = RetrofitClient.getRetrofitClient()
    private val apiService = retrofit?.create(ApiService::class.java)

    suspend fun getAnimeDetails(id : String) : Response<AnimeDetailResponse>? {
        Log.d("ApiListener", "getAnimeDetails: ${apiService?.getAnimeDetailResponse(id)}")
        return apiService?.getAnimeDetailResponse(id)
    }

    suspend fun getAnimeList() : Response<AnimeListResponse>? {
        Log.d("ApiListener", "getAnimeList: ${apiService?.getAnimeListResponse()}")
        return apiService?.getAnimeListResponse()
    }
}