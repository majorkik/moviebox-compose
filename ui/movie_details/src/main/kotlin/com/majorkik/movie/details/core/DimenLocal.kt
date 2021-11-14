package com.majorkik.movie.details.core

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal object DimenLocal {
    object Indicators {
        private const val horizontalPadding = 32
        const val totalHorizontalPadding = horizontalPadding * 2

        val paddingDp: (Dp) -> PaddingValues = { statusBarPadding ->
            PaddingValues(top = statusBarPadding + 16.dp, start = horizontalPadding.dp, end =horizontalPadding.dp)
        }
    }
}
