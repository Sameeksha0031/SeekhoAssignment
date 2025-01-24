package com.example.seekhoassignment.model.detail


import com.google.gson.annotations.SerializedName

data class Demographic(
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)