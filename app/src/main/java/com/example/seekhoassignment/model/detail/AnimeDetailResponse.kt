package com.example.seekhoassignment.model.detail


import com.google.gson.annotations.SerializedName

data class AnimeDetailResponse(
    @SerializedName("data")
    val `data`: Data
)