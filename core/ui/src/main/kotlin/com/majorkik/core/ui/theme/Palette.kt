@file:Suppress("Detekt.LongParameterList")

package com.majorkik.core.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * Created by Rodion Belovitskiy on 16.10.2021.
 */

fun lightColors(): AppColor = AppColor(
    primary = BlueCrayola,
    primaryLight = CornflowerBlue,
    secondary = RoseMadder,
    accent = VistaBlue,
    background = White,
    backgroundDark50 = Color.Black.copy(alpha = 0.5f),
    backgroundReverse = Charade,
    secondaryBackground = Alabaster,
    themeColor = Color.Black,
    ripple = Color.Black,
    text = AppColor.Text(
        primary = Charade,
        secondary = Charade.copy(alpha = 0.33f),
        white = White,
        success = VistaBlue,
    ),
    isLight = true,
)

fun darkColors(): AppColor = AppColor(
    primary = BlueCrayola,
    primaryLight = CornflowerBlue,
    secondary = RoseMadder,
    accent = VistaBlue,
    background = Charade,
    backgroundDark50 = Color.Black.copy(alpha = 0.5f),
    backgroundReverse = White,
    secondaryBackground = MineShaft,
    themeColor = White,
    ripple = Color.Black,
    text = AppColor.Text(
        primary = White,
        secondary = White.copy(alpha = 0.33f),
        white = White,
        success = VistaBlue,
    ),
    isLight = false,
)
