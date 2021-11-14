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
    secondaryBackground: Color = alabaster,
    darkBackground: Color = jet,
    isLight: Boolean = true,
): AppColor = AppColor(
    primary = primary,
    primaryLight = primaryLight,
    secondary = secondary,
    background = background,
    secondaryBackground = secondaryBackground,
    darkBackground = darkBackground,
    isLight = isLight,
)

fun darkColors(
    primary: Color = blueCrayola,
    primaryLight: Color = cornflowerBlue,
    secondary: Color = roseMadder,
    background: Color = white,
    secondaryBackground: Color = alabaster,
    darkBackground: Color = jet,
    isLight: Boolean = false,
): AppColor = AppColor(
    primary = primary,
    primaryLight = primaryLight,
    secondary = secondary,
    background = background,
    secondaryBackground = secondaryBackground,
    darkBackground = darkBackground,
    isLight = isLight,
)
