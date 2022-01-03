package com.majorkik.ui.movie.details.core

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal object DimenLocal {
    val footerPadding = PaddingValues(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)

    object Indicators {
        private const val horizontalPadding = 32

        const val totalHorizontalPadding = horizontalPadding * 2

        val heightDp: Dp = 4.dp
        val padding = PaddingValues(top = 16.dp, start = horizontalPadding.dp, end = horizontalPadding.dp)
    }
}
