package com.example.mynewsapp.di

import android.app.Application
import com.example.common.presentation.Constant
import com.example.home.data.manager.LocalUserManagerImpl
import com.example.home.data.repo.NewsRepositoryImpl
import com.example.home.domain.manager.LocalUserManager
import com.example.home.domain.repo.NewsRepository
import com.example.home.domain.usecase.GetNews
import com.example.home.domain.usecase.NewsUseCases
import com.example.network.api.home.model.NewsApi
import com.example.onboarding.domain.usecase.AppEntryUseCases
import com.example.onboarding.domain.usecase.ReadAppEntry
import com.example.onboarding.domain.usecase.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }
}