package com.toni.mvvm_compose.domain.article.repository

import com.toni.mvvm_compose.data.article.models.ArticleGetRequest
import com.toni.mvvm_compose.data.article.models.ArticleGetResponse
import com.toni.mvvm_compose.data.article.service.ArticleService

class ArticleRepository {

    private val articleService: ArticleService = ArticleService()

    suspend fun getArticles(articleGetRequest: ArticleGetRequest): List<ArticleGetResponse> {
        return articleService.getArticles(articleGetRequest)
    }
}