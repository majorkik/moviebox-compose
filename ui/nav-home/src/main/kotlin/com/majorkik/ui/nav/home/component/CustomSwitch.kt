package com.majorkik.ui.nav.home.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp


@Composable
fun CustomSwitch(
    checked: Boolean,
    trackWidth: Dp,
    trackHeight: Dp,
    thumbSize: Dp,
    gap: Dp,
    checkedThumbColor: Color,
    checkedTrackColor: Color,
    uncheckedThumbColor: Color,
    uncheckedTrackColor: Color,
    onCheckedChange: (Boolean) -> Unit,
) {
    val animatePosition = animateFloatAsState(
        targetValue = if (checked)
            with(LocalDensity.current) { (trackWidth - (thumbSize / 2) - gap).toPx() }
        else
            with(LocalDensity.current) { ((thumbSize / 2) + gap).toPx() }
    )

    Canvas(
        modifier = Modifier
            .size(width = trackWidth, height = trackHeight)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        onCheckedChange(checked.not())
                    }
                )
            }
    ) {
        // Track
        drawRoundRect(
            color = if (checked) checkedTrackColor else uncheckedTrackColor,
            cornerRadius = CornerRadius(x = trackHeight.div(2).toPx(), y = trackHeight.div(2).toPx())
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
