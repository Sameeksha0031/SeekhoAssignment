package com.example.seekhoassignment.model.detail


import com.google.gson.annotations.SerializedName

data class Prop(
    @SerializedName("from")
    val from: From,
    @SerializedName("to")
    val to: To
)