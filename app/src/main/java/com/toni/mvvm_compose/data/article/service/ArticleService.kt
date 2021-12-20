package com.toni.mvvm_compose.data.article.service

import android.util.Log
import com.toni.mvvm_compose.data.article.models.ArticleGetRequest
import com.toni.mvvm_compose.data.article.models.ArticleGetResponse
import com.toni.mvvm_compose.gateway.retrofit.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

class ArticleService {

    private val retrofit = RetrofitHelper.getRetrofit()
    private val retrofitCreate = retrofit.create(ArticleApiClient::class.java)

    suspend fun getArticles(articleGetRequest: ArticleGetRequest): List<ArticleGetResponse> {

        return withContext(Dispatchers.IO) {

            try {

                val call: Call<List<ArticleGetResponse>> = retrofitCreate.getArticles(
                    "DEMO_KEY",
                    articleGetRequest.startDate,
                    articleGetRequest.endDate
                )
                call.execute().body() ?: emptyList()
            } catch (e: Exception) {
                Log.w("ArticleService, ERROR: ",e)
                emptyList()
            }
        }
    }

}