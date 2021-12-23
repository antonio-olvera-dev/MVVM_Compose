package com.toni.mvvm_compose.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = White,
    secondary = Teal200,
    background = White,
    onBackground = Black
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Black,
    secondary = Teal200,
    background = Black,
    onBackground = White,

)

@Composable
fun MVVM_ComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}