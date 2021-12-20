package com.toni.mvvm_compose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppBarCustom() {
    TopAppBar {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(text = "MVVM_Compose",
                modifier = Modifier.padding(4.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    AppBarCustom()
}