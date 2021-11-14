@file:Suppress("Detekt.LongParameterList")

package com.majorkik.core.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * Created by Rodion Belovitskiy on 16.10.2021.
 */

fun lightColors(
    primary: Color = blueCrayola,
    primaryLight: Color = cornflowerBlue,
    secondary: Color = roseMadder,
    background: Color = white,
    backgroundReverse: Color = charade,
    secondaryBackground: Color = alabaster,
    textPrimary: Color = charade,
    textSecondary: Color = charade.copy(alpha = 0.33f),
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
    primary: Color = blueCrayola,
    primaryLight: Color = cornflowerBlue,
    secondary: Color = roseMadder,
    background: Color = charade,
    backgroundReverse: Color = white,
    secondaryBackground: Color = mineShaft,
    textPrimary: Color = white,
    textSecondary: Color = white.copy(alpha = 0.33f),
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
