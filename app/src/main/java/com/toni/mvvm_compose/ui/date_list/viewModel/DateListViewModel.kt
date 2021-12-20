package com.toni.mvvm_compose.ui.date_list.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toni.mvvm_compose.data.article.models.ArticleGetRequest
import com.toni.mvvm_compose.data.article.models.ArticleGetResponse
import com.toni.mvvm_compose.domain.article.use_case.ArticleUseCase
import kotlinx.coroutines.launch

class DateListViewModel: ViewModel() {



    private val useCase: ArticleUseCase = ArticleUseCase()
    private val articleGetRequest: ArticleGetRequest = buildArticleGetRequest()
    var loading: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)


    private val articles: MutableLiveData<List<ArticleGetResponse>> by lazy {
        MutableLiveData<List<ArticleGetResponse>>().also {
            loadArticles()
        }
    }

    fun getArticles(): LiveData<List<ArticleGetResponse>> {

        return articles
    }

    fun loadParams(pressBtnStart: Boolean, date: String) {
        if (pressBtnStart) articleGetRequest.startDate = date else articleGetRequest.endDate =
            date
    }

    private fun loadArticles() {
        viewModelScope.launch {
            loading.postValue(true)
            val newArticles = useCase.getArticles(articleGetRequest)
            if (!newArticles.isNullOrEmpty()) {
                articles.postValue(newArticles)
            }
            loading.postValue(false)
        }
    }

    private fun buildArticleGetRequest(): ArticleGetRequest {
        return ArticleGetRequest(
            startDate = "",
            endDate = ""
        )
    }


}