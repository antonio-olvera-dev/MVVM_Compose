package com.toni.mvvm_compose.shared

import android.annotation.SuppressLint
import androidx.navigation.NavHostController

object Navigate {

    @SuppressLint("StaticFieldLeak")
    lateinit var navController: NavHostController


    fun toHome() {
        navController.navigate("${Routes.Home}") {
            popUpTo("${Routes.Home}") { inclusive = true }
        }
    }

    fun toDateList() {
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

}