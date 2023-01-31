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

data class AppColorV2(
    val background: Background,
    val foreground: Foreground,
    val text: Text,
    val isLight: Boolean,
) {
    data class Background(
        val base: Color,
        val opposite: Color,
        val primary: Color,
        val accent: Color,
    )

    data class Foreground(
        val accent: Color,
    )

    data class Text(
        val primary: Color,
        val primaryOnLight: Color,
        val primaryOnDark: Color,
        val secondary: Color,
        val tertiary: Color,
        val accent: Color,
        val positive: Color,
        val negative: Color,
    )
}

@Immutable
data class AppColor(
    val primary: Color,
    val primaryLight: Color,
    val secondary: Color,
    val accent: Color,
    val background: Color,
    val backgroundReverse: Color,
    val backgroundDark50: Color,
    val secondaryBackground: Color,

    val themeColor: Color,

    val ripple: Color,

    // Groups
    val text: Text,
    val placeholder: Placeholder,
    val white: Color,

    // Screens
    val details: DetailsScreenColors,

    // Theme
    val isLight: Boolean = true
) {
    data class Text(
        val primary: Color,
        val secondary: Color,
        val white: Color,
        val success: Color
    )

    data class Placeholder(
        val background: Color,
        val backgroundDark: Color
    )

    data class DetailsScreenColors(
        val background: Color, // base
        val backgroundSecondary: Color,
        val placeholderBg: Color,
        val textPrimary: Color,
        val textSecondary: Color,
        val textPlaceholder: Color,
        val favoriteBtnDefault: Color,
        val favoriteBtnSelected: Color,
        val btnBgSecondary: Color,
        val btnTintSecondary: Color,
    )
}

@Immutable
data class AppTypography(
    val title: TextStyle = TextStyle(
        fontFamily = rubikFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.Black
    ),
    val h1: TextStyle = TextStyle(
        fontFamily = rubikFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    val h2: TextStyle = TextStyle(
        fontFamily = rubikFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    ),
    val h3: TextStyle = TextStyle(
        fontFamily = rubikFamily,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    val h4: TextStyle = TextStyle(
        fontFamily = rubikFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    ),
    val body1: TextStyle = TextStyle(
        fontFamily = montserratFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    val body2: TextStyle = TextStyle(
        fontFamily = montserratFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    val smallBold: TextStyle = TextStyle(
        fontFamily = montserratFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold
    ),
    val bodyMedium: TextStyle = TextStyle(
        fontFamily = rubikFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    ),
    val titleMedium: TextStyle = TextStyle(
        fontFamily = rubikFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    ),
    val titleSmall: TextStyle = TextStyle(
        fontFamily = rubikFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold
    ),
    val text: TextStyle = TextStyle(
        fontFamily = rubikFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal
    ),
    val textMedium: TextStyle = TextStyle(
        fontFamily = rubikFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium
    ),
    val captionMedium: TextStyle = TextStyle(
        fontFamily = rubikFamily,
        fontSize = 10.sp,
        fontWeight = FontWeight.Medium
    ),
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

internal val LocalCustomColors = staticCompositionLocalOf {
    AppColor(
        primary = Color.Unspecified,
        primaryLight = Color.Unspecified,
        secondary = Color.Unspecified,
        accent = Color.Unspecified,
        background = Color.Unspecified,
        backgroundReverse = Color.Unspecified,
        backgroundDark50 = Color.Unspecified,
        secondaryBackground = Color.Unspecified,
        themeColor = Color.Unspecified,
        ripple = Color.Unspecified,
        text = AppColor.Text(
            primary = Color.Unspecified,
            secondary = Color.Unspecified,
            white = Color.Unspecified,
            success = Color.Unspecified
        ),
        placeholder = AppColor.Placeholder(
            background = Color.Unspecified,
            backgroundDark = Color.Unspecified
        ),
        white = Color.Unspecified,
        details = AppColor.DetailsScreenColors(
            background = Color.Unspecified,
            backgroundSecondary = Color.Unspecified,
            placeholderBg = Color.Unspecified,
            textPrimary = Color.Unspecified,
            textPlaceholder = Color.Unspecified,
            favoriteBtnSelected = Color.Unspecified,
            favoriteBtnDefault = Color.Unspecified,
            btnBgSecondary = Color.Unspecified,
            textSecondary = Color.Unspecified,
            btnTintSecondary = Color.Unspecified
        ),
        isLight = false
    )
}

internal val LocalCustomTypography = staticCompositionLocalOf {
    AppTypography(
        title = TextStyle.Default,
        h1 = TextStyle.Default,
        h2 = TextStyle.Default,
        h3 = TextStyle.Default,
        h4 = TextStyle.Default,
        body1 = TextStyle.Default,
        body2 = TextStyle.Default,
        smallBold = TextStyle.Default,
        bodyMedium = TextStyle.Default,
        titleMedium = TextStyle.Default,
        titleSmall = TextStyle.Default,
        captionMedium = TextStyle.Default
    )
}

@Composable
fun MovieBoxTheme(isDark: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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
