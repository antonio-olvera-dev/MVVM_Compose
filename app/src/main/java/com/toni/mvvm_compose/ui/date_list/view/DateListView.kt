package com.toni.mvvm_compose.ui.date_list.view

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toni.mvvm_compose.data.article.models.ArticleGetResponse
import com.toni.mvvm_compose.shared.Navigate
import com.toni.mvvm_compose.ui.components.Separator
import com.toni.mvvm_compose.ui.date_list.viewModel.DateListViewModel

@Composable
fun DateListView(ctx: Context, dateListViewModel: DateListViewModel) {

    if (Navigate.Bundles.DateList.articleGetRequest != null)
        dateListViewModel.setArticleGetRequest(articleGetRequest = Navigate.Bundles.DateList.articleGetRequest!!)

    DateListComponents(ctx = ctx, dateListViewModel = dateListViewModel).Body()
}


private class DateListComponents(val ctx: Context, val dateListViewModel: DateListViewModel) {

    @Composable
    fun Body() {

        val articles by dateListViewModel.articles.observeAsState()

        Box(Modifier.fillMaxSize()) {

            Loader(Modifier.align(Alignment.Center))
            ArticleLazyColumn(articles, Modifier.align(Alignment.TopStart))
        }
    }

    @Composable
    private fun ArticleLazyColumn(articles: List<ArticleGetResponse>?, modifier: Modifier) {
        LazyColumn(modifier = modifier) {
            if (articles != null && articles.count() > 0) {
                items(articles) { article ->
                    Separator()
                    Article(article)
                    Separator()
                }
            }
        }
    }

    @Composable
    private fun Article(article: ArticleGetResponse) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable {
                Navigate.toDetailsArticle(articleGetResponse = article)
            },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = article.date,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp))
        }
    }

    @Composable
    private fun Loader(modifier: Modifier) {
        val loading by dateListViewModel.loading.observeAsState()
        if (loading!!) {
            CircularProgressIndicator(modifier = modifier)
        }
    }


}