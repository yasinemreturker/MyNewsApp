package com.example.network.api.home.model

import com.example.common.presentation.Constant
import com.example.network.api.home.model.remote.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = Constant.API_KEY
    ): NewsResponse
}