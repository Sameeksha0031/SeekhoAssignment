package com.example.seekhoassignment.networking

import com.example.seekhoassignment.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofitBuilder : Retrofit ?= null

    fun getRetrofitClient() : Retrofit? {
        if(retrofitBuilder == null){
            val okHttpClient = OkHttpClient.Builder()

            retrofitBuilder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return  retrofitBuilder
    }
}