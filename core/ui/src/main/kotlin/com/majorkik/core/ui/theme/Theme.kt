package com.majorkik.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleTheme
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
    val accent: Color,
    val background: Color,
    val backgroundReverse: Color,
    val secondaryBackground: Color,

    val themeColor: Color,

    val ripple: Color,

    // Text
    val text: Text,
    // Theme
    val isLight: Boolean = true
) {
    data class Text(
        val primary: Color,
        val secondary: Color
    )
}

@Immutable
data class AppTypography(
    val title: TextStyle = TextStyle(fontFamily = rubikFamily, fontSize = 24.sp, fontWeight = FontWeight.Black),
    val h1: TextStyle = TextStyle(fontFamily = rubikFamily, fontSize = 24.sp, fontWeight = FontWeight.Bold),
    val h2: TextStyle = TextStyle(fontFamily = rubikFamily, fontSize = 20.sp, fontWeight = FontWeight.Bold),
    val h3: TextStyle = TextStyle(fontFamily = rubikFamily, fontSize = 18.sp, fontWeight = FontWeight.Bold),
    val h4: TextStyle = TextStyle(fontFamily = rubikFamily, fontSize = 16.sp, fontWeight = FontWeight.Bold),
    val body1: TextStyle = TextStyle(fontFamily = montserratFamily, fontSize = 16.sp, fontWeight = FontWeight.Medium),
    val body2: TextStyle = TextStyle(fontFamily = montserratFamily, fontSize = 14.sp, fontWeight = FontWeight.Normal),
    val smallBold: TextStyle = TextStyle(fontFamily = montserratFamily, fontSize = 12.sp, fontWeight = FontWeight.Bold),
    val bodyMedium: TextStyle = TextStyle(fontFamily = rubikFamily, fontSize = 14.sp, fontWeight = FontWeight.Medium),
    val titleMedium: TextStyle = TextStyle(fontFamily = rubikFamily, fontSize = 14.sp, fontWeight = FontWeight.Bold),
)

@Immutable
private object SecondaryRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = RippleTheme.defaultRippleColor(
        contentColor = MovieBoxTheme.colors.ripple,
        lightTheme = MovieBoxTheme.colors.isLight
    )

    @Composable
    override fun rippleAlpha() = RippleTheme.defaultRippleAlpha(
        contentColor = MovieBoxTheme.colors.ripple,
        lightTheme = MovieBoxTheme.colors.isLight
    )
}

internal val LocalCustomColors = staticCompositionLocalOf { darkColors() }

internal val LocalCustomTypography = staticCompositionLocalOf { AppTypography() }

@Composable
fun MovieBoxTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val customColors = if (isDark) darkColors() else lightColors()
    val customTypography = AppTypography()

    CompositionLocalProvider(
        LocalCustomColors provides customColors,
        LocalCustomTypography provides customTypography,
        LocalRippleTheme provides SecondaryRippleTheme,
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
