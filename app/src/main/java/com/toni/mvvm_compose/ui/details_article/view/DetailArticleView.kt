package com.toni.mvvm_compose.ui.details_article.view

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.toni.mvvm_compose.shared.Navigate


@Composable
fun DetailsArticleView(ctx: Context) {
    DetailsArticleComponents(ctx = ctx).Body()
}


private class DetailsArticleComponents(val ctx: Context) {

    @Composable
    fun Body() {

        Column(Modifier.fillMaxSize()) {
            Text(text = "DetailsArticleView")
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
            Button(onClick = {
                Navigate.toHome()
            }) {
                Text(text = "Go to Home")
            }
        }
    }

}