package com.example.home.domain.usecase

import com.example.home.domain.repo.NewsRepository
import com.example.network.api.home.model.local.Article

class SelectArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(url: String): Article?{
        return newsRepository.selectArticle(url)
    }

}