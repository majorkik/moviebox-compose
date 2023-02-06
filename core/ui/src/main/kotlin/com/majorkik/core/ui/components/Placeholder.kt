package com.majorkik.core.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.majorkik.core.ui.R
import com.majorkik.core.ui.theme.MBTheme

@Composable
@DrawableRes
fun getPopcornPlaceholderResId(isLight: Boolean = MBTheme.colors.isLight) = if (isLight) {
    R.drawable.bg_placeholder_popcorn_light
} else {
    R.drawable.bg_placeholder_popcorn_dark
}

@Composable
fun getSmallProfilePlaceholder(isLight: Boolean = MBTheme.colors.isLight) = if (isLight) {
    painterResource(id = R.drawable.placeholder_profile_small_light)
} else {
    painterResource(id = R.drawable.placeholder_profile_small_dark)
}
