package com.toni.mvvm_compose.shared

import android.annotation.SuppressLint
import androidx.navigation.NavHostController
import com.toni.mvvm_compose.data.article.models.ArticleGetRequest

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

    fun toDetailsArticle() {
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
    }

}