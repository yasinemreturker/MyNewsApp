package com.example.network.api.home.model.remote

import com.example.network.api.home.model.local.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)