package com.majorkik.core.ui.components

import androidx.annotation.DrawableRes
import com.majorkik.core.ui.R

@DrawableRes
fun getPopcornPlaceholderResId(isLight: Boolean) = if (isLight) {
    R.drawable.bg_placeholder_popcorn_light
} else {
    R.drawable.bg_placeholder_popcorn_dark
}
