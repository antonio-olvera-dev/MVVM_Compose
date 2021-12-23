package com.toni.mvvm_compose.shared

import android.annotation.SuppressLint
import androidx.navigation.NavHostController
import com.toni.mvvm_compose.data.article.models.ArticleGetRequest
import com.toni.mvvm_compose.data.article.models.ArticleGetResponse

object Navigate {

    @SuppressLint("StaticFieldLeak")
    lateinit var navController: NavHostController

    fun toHome() {
        navController.navigate("${Routes.Home}") {
            popUpTo("${Routes.Home}") { inclusive = true }
        }
    }

    fun toDateList(articleGetRequest: ArticleGetRequest) {
        Bundles.DateList.articleGetRequest = articleGetRequest
        navController.navigate("${Routes.DateList}")
    }

    fun toDetailsArticle(articleGetResponse: ArticleGetResponse) {
        Bundles.DetailsArticle.articleGetResponse = articleGetResponse
        navController.navigate("${Routes.DetailsArticle}")
    }

    enum class Routes {
        Home,
        DateList,
        DetailsArticle
    }

    object Bundles {
        object DateList {
            var articleGetRequest: ArticleGetRequest? = null
        }

        object DetailsArticle {
            var articleGetResponse: ArticleGetResponse? = null
        }
    }

}