package com.toni.mvvm_compose.ui.date_list.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toni.mvvm_compose.data.article.models.ArticleGetRequest
import com.toni.mvvm_compose.data.article.models.ArticleGetResponse
import com.toni.mvvm_compose.domain.article.use_case.ArticleUseCase
import kotlinx.coroutines.launch

class DateListViewModel : ViewModel() {


    private val useCase: ArticleUseCase = ArticleUseCase()
    private var articleGetRequest: ArticleGetRequest? = null


    private val _articles: MutableLiveData<List<ArticleGetResponse>> by lazy {
        MutableLiveData<List<ArticleGetResponse>>().also {
            loadArticles()
        }
    }

    val articles: LiveData<List<ArticleGetResponse>>
        get() = _articles

    private var _loading: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    val loading: LiveData<Boolean>
        get() = _loading


    fun setArticleGetRequest(articleGetRequest: ArticleGetRequest) {
        this.articleGetRequest = articleGetRequest
    }

    private fun loadArticles() {

        viewModelScope.launch {

            if (articleGetRequest != null) {
                _loading.postValue(true)
                val newArticles = useCase.getArticles(articleGetRequest!!)
                if (!newArticles.isNullOrEmpty()) {
                    _articles.postValue(newArticles)
                }
                _loading.postValue(false)
            }

        }
    }

}