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
    placeholder = AppColor.Placeholder(
        background = Alabaster,
        backgroundDark = Gallery
    ),
    white = Color.White,
    details = AppColor.DetailsScreenColors(
        background = White,
        backgroundSecondary = Alabaster,
        placeholderBg = Charade,
        textPrimary = Charade,
        textSecondary = Silver,
        textPlaceholder = White,
        favoriteBtnDefault = SilverChalice,
        favoriteBtnSelected = RedOrange,
        btnBgSecondary = Alabaster
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
    placeholder = AppColor.Placeholder(
        background = MineShaftLight,
        backgroundDark = MineShaftLight
    ),
    white = Color.White,
    details = AppColor.DetailsScreenColors(
        background = Charade,
        backgroundSecondary = CodGray,
        placeholderBg = White,
        textPrimary = White,
        textSecondary = Emperor,
        textPlaceholder = Charade,
        favoriteBtnDefault = DoveGray,
        favoriteBtnSelected = RedOrange,
        btnBgSecondary = CodGray
    ),
    isLight = false,
)
