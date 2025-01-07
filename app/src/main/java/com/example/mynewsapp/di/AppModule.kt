package com.example.mynewsapp.di

import android.app.Application
import com.example.home.data.manager.LocalUserManagerImpl
import com.example.home.domain.manager.LocalUserManager
import com.example.onboarding.domain.usecase.AppEntryUseCases
import com.example.onboarding.domain.usecase.ReadAppEntry
import com.example.onboarding.domain.usecase.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

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

}