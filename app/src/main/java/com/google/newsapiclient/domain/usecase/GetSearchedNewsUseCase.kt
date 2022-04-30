package com.google.newsapiclient.domain.usecase

import com.google.newsapiclient.data.model.APIResponse
import com.google.newsapiclient.data.util.Resource
import com.google.newsapiclient.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, searchQuery: String, page: Int): Resource<APIResponse>{
        return newsRepository.getSearchedNews(country, searchQuery, page)
    }

}