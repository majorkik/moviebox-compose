package com.majorkik.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

object MBTheme {
    val colors: AppColor
        @Composable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        get() = LocalAppTypography.current
}

@Composable
fun MBTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors: AppColor = if (isDark) AppColor.dark() else AppColor.light()
    val typography: AppTypography = MBTheme.typography

    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppTypography provides typography,
        LocalRippleTheme provides AppRipple,
        content = content
    )
}
