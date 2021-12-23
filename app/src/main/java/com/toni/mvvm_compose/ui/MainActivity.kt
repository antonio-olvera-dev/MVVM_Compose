package com.toni.mvvm_compose.ui

import HomeView
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.toni.mvvm_compose.shared.Navigate
import com.toni.mvvm_compose.ui.components.AppBarCustom
import com.toni.mvvm_compose.ui.home.viewModel.HomeViewModel
import com.toni.mvvm_compose.ui.theme.MVVM_ComposeTheme

class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()

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
                        composable("home") { HomeView(ctx = LocalContext.current, homeViewModel) }
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


