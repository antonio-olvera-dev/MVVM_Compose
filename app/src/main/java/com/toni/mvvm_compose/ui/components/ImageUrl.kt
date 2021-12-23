package com.toni.mvvm_compose.ui.components


import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.rememberImagePainter


@Composable
fun ImageUrl(
    url: String,
    contentDescription: String = "",
    modifier: Modifier = Modifier,
    crossFade: Boolean = true,
) {
    Image(
        painter = rememberImagePainter(url, builder = {
            crossfade(crossFade)
        }),
        contentDescription = contentDescription,
        modifier = modifier
    )
}