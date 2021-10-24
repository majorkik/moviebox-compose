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
    isLight: Boolean = true,
): AppColor = AppColor(
    primary = primary,
    primaryLight = primaryLight,
    secondary = secondary,
    background = background,
    isLight = isLight,
)

fun darkColors(
    primary: Color = blueCrayola,
    primaryLight: Color = cornflowerBlue,
    secondary: Color = roseMadder,
    background: Color = white,
    isLight: Boolean = false,
): AppColor = AppColor(
    primary = primary,
    primaryLight = primaryLight,
    secondary = secondary,
    background = background,
    isLight = isLight,
)
