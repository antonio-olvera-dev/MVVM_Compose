package com.toni.mvvm_compose.ui.home.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.toni.mvvm_compose.ui.theme.MVVM_ComposeTheme

@Composable
fun HomeView() {
    Text("Home")
}


@Preview(showBackground = true, heightDp = 500, widthDp = 500)
@Composable
fun DefaultPreview() {
    MVVM_ComposeTheme {
        HomeView()
    }
}