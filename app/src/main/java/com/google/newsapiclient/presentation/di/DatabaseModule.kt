package com.google.newsapiclient.presentation.di

import android.app.Application
import androidx.room.Room
import com.google.newsapiclient.data.db.ArticleDAO
import com.google.newsapiclient.data.db.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideNewsDatabase(application: Application): ArticleDatabase {
        return Room.databaseBuilder(application, ArticleDatabase::class.java, "news_db")
            .fallbackToDestructiveMigration() // This will allow room to destructively replace tables if migrations that would migrate old database schemas to the latest schema version
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(articleDatabase: ArticleDatabase): ArticleDAO {
        return articleDatabase.getArticleDAO()
    }

}