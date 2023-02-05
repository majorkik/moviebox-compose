package com.majorkik.core.ui.theme

import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable

@Immutable
internal object AppRipple : RippleTheme {
    @Composable
    override fun defaultColor() = RippleTheme.defaultRippleColor(
        contentColor = MBTheme.colors.background.ripple,
        lightTheme = MBTheme.colors.isLight
    )

    @Composable
    override fun rippleAlpha() = RippleTheme.defaultRippleAlpha(
        contentColor = MBTheme.colors.background.ripple,
        lightTheme = MBTheme.colors.isLight
    )
}
