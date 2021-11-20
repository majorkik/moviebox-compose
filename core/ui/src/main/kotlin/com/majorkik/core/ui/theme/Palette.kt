@file:Suppress("Detekt.LongParameterList")

package com.majorkik.core.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * Created by Rodion Belovitskiy on 16.10.2021.
 */

fun lightColors(
    primary: Color = BlueCrayola,
    primaryLight: Color = CornflowerBlue,
    secondary: Color = RoseMadder,
    background: Color = White,
    backgroundReverse: Color = Charade,
    secondaryBackground: Color = Alabaster,
    textPrimary: Color = Charade,
    textSecondary: Color = Charade.copy(alpha = 0.33f),
    isLight: Boolean = true,
): AppColor = AppColor(
    primary = primary,
    primaryLight = primaryLight,
    secondary = secondary,
    background = background,
    backgroundReverse = backgroundReverse,
    secondaryBackground = secondaryBackground,
    text = AppColor.Text(
        primary = textPrimary,
        secondary = textSecondary
    ),
    isLight = isLight,
)

fun darkColors(
    primary: Color = BlueCrayola,
    primaryLight: Color = CornflowerBlue,
    secondary: Color = RoseMadder,
    background: Color = Charade,
    backgroundReverse: Color = White,
    secondaryBackground: Color = MineShaft,
    textPrimary: Color = White,
    textSecondary: Color = White.copy(alpha = 0.33f),
    isLight: Boolean = false,
): AppColor = AppColor(
    primary = primary,
    primaryLight = primaryLight,
    secondary = secondary,
    background = background,
    backgroundReverse = backgroundReverse,
    secondaryBackground = secondaryBackground,
    text = AppColor.Text(
        primary = textPrimary,
        secondary = textSecondary
    ),
    isLight = isLight,
)
