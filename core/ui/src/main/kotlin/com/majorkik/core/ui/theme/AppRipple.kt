package com.majorkik.core.ui.theme

import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable

@Immutable
internal object AppRipple : RippleTheme {
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
