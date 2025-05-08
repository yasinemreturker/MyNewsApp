package com.example.home.domain.repo

import androidx.paging.PagingData
import com.example.network.api.home.model.local.Article
import kotlinx.coroutines.flow.Flow


interface NewsRepository {
    fun getNews(sources: List<String>): Flow<PagingData<Article>>
    suspend fun selectArticle(url: String): Article?
}