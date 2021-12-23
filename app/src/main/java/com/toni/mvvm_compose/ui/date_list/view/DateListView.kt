package com.toni.mvvm_compose.ui.date_list.view

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
import com.toni.mvvm_compose.ui.date_list.viewModel.DateListViewModel

@Composable
fun DateListView(ctx: Context, dateListViewModel: DateListViewModel) {
    DateListComponents(ctx = ctx, dateListViewModel = dateListViewModel).Body()
}


private class DateListComponents(val ctx: Context, val dateListViewModel: DateListViewModel) {

    @Composable
    fun Body() {
        Column(Modifier.fillMaxSize()) {
            Text(text = "DateListView")
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
            Button(onClick = {
                Navigate.toDetailsArticle()
            }) {
                Text(text = "Go to DetailsArticleView")
            }
        }
    }

}