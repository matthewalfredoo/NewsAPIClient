package com.google.newsapiclient.presentation.di

import com.google.newsapiclient.data.repository.NewsRepositoryImpl
import com.google.newsapiclient.data.repository.datasource.NewsLocalDataSource
import com.google.newsapiclient.data.repository.datasource.NewsRemoteDataSource
import com.google.newsapiclient.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ): NewsRepository{
        return NewsRepositoryImpl(
            newsRemoteDataSource,
            newsLocalDataSource
        )
    }

}