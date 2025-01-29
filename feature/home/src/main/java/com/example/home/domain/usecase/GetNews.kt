package com.example.home.domain.usecase

import androidx.paging.PagingData
import com.example.home.domain.repo.NewsRepository
import com.example.network.api.home.model.local.Article
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }

}