package com.majorkik.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

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
        val neutral1: Color = Color.Black.copy(alpha = 0.5f),
        /** Secondary elements on [base] backgrounds: buttons, cards */
        val elevation1: Color = if (isLight) Alabaster else CodGray,
        /** Main ripple color for interactive elements */
        val ripple: Color = Color.Black,
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
        /** Transparent elements */
        val transparent: Color = Color.Transparent,
        /** Base dividers color */
        val divider: Color = if (isLight) AlabasterLight else MineShaft,
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
        val tertiary: Color = Color.Black.copy(alpha = 0.5f),
        /** Accent text color */
        val accent: Color = BlueCrayola,
        /** Accent text for positive containers */
        val positiveAccent: Color = VistaBlue,
        /** TMDB brand */
        val tmdbBrand: Color = VistaBlue
    )

    companion object {
        @Composable
        fun systemTheme(): AppColor = if (isSystemInDarkTheme()) dark() else light()

        fun dark(): AppColor = AppColor(false)

        fun light(): AppColor = AppColor(true)
    }
}

internal val LocalAppColors = staticCompositionLocalOf { AppColor.light() }
