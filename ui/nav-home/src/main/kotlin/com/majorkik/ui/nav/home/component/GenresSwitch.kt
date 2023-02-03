package com.majorkik.ui.nav.home.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.majorkik.core.ui.theme.MovieBoxTheme

@Composable
internal fun GenresSwitch(
    checked: Boolean,
    checkedThumbColor: Color = MovieBoxTheme.colors.background.opposite,
    uncheckedThumbColor: Color = MovieBoxTheme.colors.background.opposite,
    checkedTrackColor: Color = MovieBoxTheme.colors.background.elevation1,
    uncheckedTrackColor: Color = MovieBoxTheme.colors.background.elevation1,
) {
    // Sizes
    val trackWidth = 24.dp
    val trackHeight = 12.dp
    val thumbSize = 8.dp
    val gap = 2.dp

    val animatePosition = animateFloatAsState(
        targetValue = if (checked) {
            with(LocalDensity.current) { (trackWidth - (thumbSize / 2) - gap).toPx() }
        } else {
            with(LocalDensity.current) { ((thumbSize / 2) + gap).toPx() }
        }
    )

    Canvas(
        modifier = Modifier
            .size(width = trackWidth, height = trackHeight)
            .clip(CircleShape)
    ) {
        // Track
        drawRoundRect(
            color = if (checked) checkedTrackColor else uncheckedTrackColor,
            cornerRadius = CornerRadius(
                x = trackHeight.div(2).toPx(),
                y = trackHeight.div(2).toPx()
            )
        )
        // Thumb
        drawCircle(
            color = if (checked) checkedThumbColor else uncheckedThumbColor,
            radius = (thumbSize / 2).toPx(),
            center = Offset(
                x = animatePosition.value,
                y = size.height / 2
            )
        )
    }
}
