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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toni.mvvm_compose.data.article.models.ArticleGetResponse
import com.toni.mvvm_compose.shared.Navigate


@Composable
fun DetailsArticleView(ctx: Context) {
    DetailsArticleComponents(ctx = ctx).Body()
}


private class DetailsArticleComponents(val ctx: Context) {

    val article: ArticleGetResponse = Navigate.Bundles.DetailsArticle.articleGetResponse!!

    @Composable
    fun Body() {

        Column(Modifier
            .fillMaxSize()
            .padding(10.dp)
        ) {
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
            Image()
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
            Title()
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
            Description()
        }
    }


    @Composable
    private fun Image() {
        Text(
            text = article.hdUrl,
            fontSize = 16.sp,
        )

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