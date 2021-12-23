package com.toni.mvvm_compose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.toni.mvvm_compose.ui.theme.Gray100

@Composable
fun Separator() {
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(0.5.dp)
        .background(color = Gray100)
    )
}