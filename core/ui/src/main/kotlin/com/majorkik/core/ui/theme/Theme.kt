package com.majorkik.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
class AppColor internal constructor(
    val isLight: Boolean,
    val background: Background = Background(isLight),
    val foreground: Foreground = Foreground(isLight),
    val text: Text = Text(isLight),
) {
    @Immutable
    class Background internal constructor(
        private val isLight: Boolean,
        /** The main background of the application */
        val base: Color = if (isLight) White else Charade,
        /** Opposite background [base] */
        val opposite: Color = if (isLight) Charade else White,
        /** Container for interactive elements */
        val accent: Color = BlueCrayola,
        /** Information elements */
        val info: Color = RoseMadder,
        /** Transparent containers */
        val neutral1: Color = Black.copy(alpha = 0.5f),
        /** Secondary elements on [base] backgrounds: buttons, cards */
        val elevation1: Color = if (isLight) Alabaster else CodGray,
        /** Main ripple color for interactive elements */
        val ripple: Color = Black,
    )

    @Immutable
    class Foreground internal constructor(
        private val isLight: Boolean,
        /** Interactive elements */
        val accent: Color = BlueCrayola,
        /** Accent neutral elements on [Background.base] background */
        val neutralAccent: Color = if (isLight) Charade else White,
        /** Accent elements for positive containers */
        val positiveAccent: Color = VistaBlue,
        /** Accent elements for negative containers */
        val negativeAccent: Color = RoseMadder,
        /** Accent elements for info containers */
        val infoAccent: Color = if (isLight) SilverChalice else DoveGray,
        /** Elements on light backgrounds */
        val onLight: Color = Charade,
        /** Elements on dark backgrounds */
        val onDark: Color = White,
    )

    @Immutable
    class Text internal constructor(
        private val isLight: Boolean,
        /** Text on backgrounds: [Background.base] */
        val primary: Color = if (isLight) Charade else White,
        /** Text on light backgrounds */
        val primaryOnLight: Color = Charade,
        /** Text on dark backgrounds */
        val primaryOnDark: Color = White,
        /** Text on opposite background */
        val primaryOnOpposite: Color = if (isLight) White else Charade,
        /** Text on inactive background */
        val primaryInactive: Color = if (isLight) Alabaster else CodGray,
        /** Secondary text on backgrounds: [Background.base] */
        val secondary: Color = if (isLight) Silver else Emperor,
        /** Placeholders text */
        val tertiary: Color = Black.copy(alpha = 0.5f),
        /** Accent text color */
        val accent: Color = BlueCrayola,
        /** Accent text for positive containers */
        val positiveAccent: Color = VistaBlue,
    )

    companion object {
        @Composable
        fun systemTheme(): AppColor = if (isSystemInDarkTheme()) dark() else light()

        fun dark(): AppColor = AppColor(false)

        fun light(): AppColor = AppColor(true)
    }
}

internal val LocalAppColors = staticCompositionLocalOf { AppColor.light() }

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
        contentColor = MovieBoxTheme.colors.background.ripple,
        lightTheme = MovieBoxTheme.colors.isLight
    )

    @Composable
    override fun rippleAlpha() = RippleTheme.defaultRippleAlpha(
        contentColor = MovieBoxTheme.colors.background.ripple,
        lightTheme = MovieBoxTheme.colors.isLight
    )
}

internal val LocalCustomTypography = staticCompositionLocalOf { AppTypography() }

@Composable
fun MBTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors: AppColor = if (isDark) AppColor.dark() else AppColor.light()
    val customTypography: AppTypography = MovieBoxTheme.typography

    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalCustomTypography provides customTypography,
        LocalRippleTheme provides SecondaryRippleTheme,
        content = content
    )
}

object MovieBoxTheme {
    val colors: AppColor
        @Composable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        get() = LocalCustomTypography.current
}
