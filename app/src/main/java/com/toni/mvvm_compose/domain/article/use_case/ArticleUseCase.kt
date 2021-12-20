package com.toni.mvvm_compose.domain.article.use_case

import com.toni.mvvm_compose.data.article.models.ArticleGetRequest
import com.toni.mvvm_compose.data.article.models.ArticleGetResponse
import com.toni.mvvm_compose.domain.article.repository.ArticleRepository

class ArticleUseCase {

    private val repository:ArticleRepository = ArticleRepository()

    suspend  fun getArticles(articleGetRequest: ArticleGetRequest): List<ArticleGetResponse> {
        return repository.getArticles(articleGetRequest)
    }
}