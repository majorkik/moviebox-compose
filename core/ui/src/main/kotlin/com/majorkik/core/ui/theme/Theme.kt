package com.majorkik.core.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class AppColor(
    val primary: Color,
    val primaryLight: Color,
    val secondary: Color,
    val background: Color,
    val secondaryBackground: Color,
    val darkBackground:Color,
    val isLight: Boolean = true
)

@Immutable
data class AppTypography(
    val title: TextStyle = TextStyle(fontFamily = rubikFamily, fontSize = 24.sp, fontWeight = FontWeight.Black),
    val h1: TextStyle = TextStyle(fontFamily = rubikFamily, fontSize = 24.sp, fontWeight = FontWeight.Bold),
    val h2: TextStyle = TextStyle(fontFamily = rubikFamily, fontSize = 20.sp, fontWeight = FontWeight.Bold),
    val h3: TextStyle = TextStyle(fontFamily = rubikFamily, fontSize = 18.sp, fontWeight = FontWeight.Bold),
    val h4: TextStyle = TextStyle(fontFamily = rubikFamily, fontSize = 16.sp, fontWeight = FontWeight.Bold),
    val body1: TextStyle = TextStyle(fontFamily = montserratFamily, fontSize = 16.sp, fontWeight = FontWeight.Medium),
    val body2: TextStyle = TextStyle(fontFamily = montserratFamily, fontSize = 14.sp, fontWeight = FontWeight.Normal),
)

internal val LocalCustomColors = staticCompositionLocalOf { lightColors() }

internal val LocalCustomTypography = staticCompositionLocalOf { AppTypography() }

@Composable
fun MovieBoxTheme(
    content: @Composable () -> Unit
) {
    val customColors = lightColors()
    val customTypography = AppTypography()

    CompositionLocalProvider(
        LocalCustomColors provides customColors,
        LocalCustomTypography provides customTypography,
        content = content
    )
}

object MovieBoxTheme {
    val colors: AppColor
        @Composable
        get() = LocalCustomColors.current

    val typography: AppTypography
        @Composable
        get() = LocalCustomTypography.current
}
