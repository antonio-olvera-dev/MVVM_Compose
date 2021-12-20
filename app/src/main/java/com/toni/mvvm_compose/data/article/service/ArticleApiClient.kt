package com.toni.mvvm_compose.data.article.service

import com.toni.mvvm_compose.data.article.models.ArticleGetResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApiClient {

    @GET("planetary/apod")
    fun getArticles(

        @Query("api_key") apiKey: String,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String

    ): Call<List<ArticleGetResponse>>
}