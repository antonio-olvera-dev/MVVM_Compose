package com.toni.mvvm_compose.ui.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.toni.mvvm_compose.data.article.models.ArticleGetRequest

class HomeViewModel : ViewModel() {

    private val _articleGetRequest = MutableLiveData<ArticleGetRequest>(ArticleGetRequest(
        startDate = "1995-06-19",
        endDate = "1995-07-19"
    ))
    val articleGetRequest: LiveData<ArticleGetRequest>
        get() = _articleGetRequest

    fun setArticleGetRequest(
        startDate: String = articleGetRequest.value!!.startDate,
        endDate: String = articleGetRequest.value!!.endDate,
    ) {

        val newArticleGetRequest: ArticleGetRequest = ArticleGetRequest(
            startDate = startDate,
            endDate = endDate
        )
        _articleGetRequest.postValue(newArticleGetRequest)
    }
}

