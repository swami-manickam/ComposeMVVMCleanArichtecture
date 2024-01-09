package com.compose.cryptocurrency.presentation.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorPalette = darkColors(
    primary = ColorOnPrimary,
    background = TextWhite,
    onBackground = ColorOnPrimary,
    onPrimary = TextBlue,
    onSecondary = TextRed,
    primaryVariant =ColorOnPrimary,
    secondaryVariant = TextWhite,
    secondary = DarkBlue
)

private val LightColorPalette = lightColors(
    primary = ColorOnPrimary,
    background = ColorPrimary,
    onBackground = TextWhite,
    onPrimary = TextBlue,
    onSecondary = TextRed,
    primaryVariant =ColorOnPrimary,
    secondaryVariant = TextWhite,
    secondary = DarkBlue
)

@Composable
fun CryptocurrencyAppYTTheme(darkTheme: Boolean = true, content: @Composable() () -> Unit) {
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

@Composable
fun CryptoMaterial3AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val dynamicColors = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val colors = when {
        dynamicColors && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
        dynamicColors && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
        darkTheme -> DarkColorPalette
        else -> LightColorPalette
    }

   /* androidx.compose.material3.MaterialTheme(
        colorScheme = colors, typography = Typography, shapes = Shapes,
        content = content
    )*/

}