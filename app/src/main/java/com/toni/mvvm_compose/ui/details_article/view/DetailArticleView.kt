package com.toni.mvvm_compose.ui.details_article.view

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.toni.mvvm_compose.data.article.models.ArticleGetResponse
import com.toni.mvvm_compose.shared.Navigate
import com.toni.mvvm_compose.ui.components.ImageUrl


@Composable
fun DetailsArticleView(ctx: Context) {
    DetailsArticleComponents(ctx = ctx).Body()
}


private class DetailsArticleComponents(val ctx: Context) {

    val article: ArticleGetResponse = Navigate.Bundles.DetailsArticle.articleGetResponse!!

    @Composable
    fun Body() {

        val scrollState = rememberScrollState()

        Column(Modifier
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
            Image()
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
            Title()
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
            Description()
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
        }
    }


    @Composable
    private fun Image() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ImageUrl(
                article.url, modifier = Modifier
                    .align(Alignment.Center)
                    .size(200.dp)
            )
        }
    }

    @Composable
    private fun Title() {
        Text(
            text = article.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }

    @Composable
    private fun Description() {
        Text(
            text = article.explanation,
            fontSize = 16.sp,
        )
    }

}