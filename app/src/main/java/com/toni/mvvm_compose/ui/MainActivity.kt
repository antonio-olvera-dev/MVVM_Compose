package com.toni.mvvm_compose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.toni.mvvm_compose.shared.Navigate
import com.toni.mvvm_compose.ui.components.AppBarCustom
import com.toni.mvvm_compose.ui.home.view.HomeView
import com.toni.mvvm_compose.ui.theme.MVVM_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView()
        }
    }

    @Composable
    private fun MainView() {
        MVVM_ComposeTheme {

            Navigate.navController = rememberNavController()

            Surface(color = MaterialTheme.colors.background) {
                Scaffold(
                    topBar = {
                        AppBarCustom()
                    }
                ) {
                    NavHost(navController = Navigate.navController, startDestination = "home") {
                        composable("home") { HomeView(ctx = applicationContext) }
                    }
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MainView()
    }
}


