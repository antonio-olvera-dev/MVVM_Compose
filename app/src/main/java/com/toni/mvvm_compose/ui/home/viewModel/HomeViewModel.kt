package com.toni.mvvm_compose.ui.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.toni.mvvm_compose.data.article.models.ArticleGetRequest

class HomeViewModel : ViewModel() {


    private val articleGetRequest: MutableLiveData<ArticleGetRequest> by lazy {
        MutableLiveData<ArticleGetRequest>().also {
            loadArticleGetRequest()
        }
    }

    fun getArticleGetRequest(): LiveData<ArticleGetRequest> {
        return articleGetRequest
    }


    private fun loadArticleGetRequest() {

        articleGetRequest.postValue(buildArticleGetRequest())
    }

    private fun buildArticleGetRequest(): ArticleGetRequest {
        return ArticleGetRequest(
            startDate = "1995-06-19",
            endDate = "1995-07-19"
        )
    }


}

