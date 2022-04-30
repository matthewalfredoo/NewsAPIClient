package com.google.newsapiclient.domain.usecase

import com.google.newsapiclient.data.model.Article
import com.google.newsapiclient.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.deleteNews(article)

}