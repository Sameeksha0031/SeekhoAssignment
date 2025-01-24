package com.example.seekhoassignment.networking

import com.example.seekhoassignment.model.AnimeListResponse
import com.example.seekhoassignment.model.detail.AnimeDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("v4/top/anime")
    suspend fun getAnimeListResponse() : Response<AnimeListResponse>

    @GET("v4/anime/{anime_id}")
    suspend fun  getAnimeDetailResponse(@Path("anime_id") id : String) : Response<AnimeDetailResponse>
}