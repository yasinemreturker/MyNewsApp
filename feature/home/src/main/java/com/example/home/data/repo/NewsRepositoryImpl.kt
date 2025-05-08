package com.example.home.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.home.data.remote.NewsPagingSource
import com.example.home.domain.repo.NewsRepository
import com.example.network.api.home.model.NewsApi
import com.example.network.api.home.model.local.Article
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override suspend fun selectArticle(url: String): Article? {
        TODO("Not yet implemented")
    }

//    override suspend fun selectArticle(url: String): Article? {
//        return newsDao.getArticle(url)
//    }

}