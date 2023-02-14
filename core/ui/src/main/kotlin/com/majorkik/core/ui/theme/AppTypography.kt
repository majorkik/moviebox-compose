package com.majorkik.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
class AppTypography internal constructor(
    val header: Header = Header(),
    val body: Body = Body(),
    val ui: UI = UI()
) {
    @Immutable
    class Header internal constructor(
        val titleLarge: TextStyle = TextStyle(
            fontFamily = rubikFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.Black
        ),
        val titleMedium: TextStyle = TextStyle(
            fontFamily = rubikFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        ),
        val titleSmall: TextStyle = TextStyle(
            fontFamily = rubikFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        ),
        val h1: TextStyle = TextStyle(
            fontFamily = rubikFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        ),
        val h2: TextStyle = TextStyle(
            fontFamily = rubikFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        ),
        val h3: TextStyle = TextStyle(
            fontFamily = rubikFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        ),
        val h4: TextStyle = TextStyle(
            fontFamily = rubikFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        ),
    )

    @Immutable
    class Body internal constructor(
        val medium: TextStyle = TextStyle(
            fontFamily = rubikFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        ),
        val text: TextStyle = TextStyle(
            fontFamily = rubikFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        ),
        val textMedium: TextStyle = TextStyle(
            fontFamily = rubikFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        ),
    )

    @Immutable
    class UI internal constructor(
        val captionMedium: TextStyle = TextStyle(
            fontFamily = rubikFamily,
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium
        ),
        val logoLarge: TextStyle = TextStyle(
            fontFamily = rubikFamily,
            fontSize = 42.sp,
            fontWeight = FontWeight.Black
        ),
    )
}

internal val LocalAppTypography = staticCompositionLocalOf { AppTypography() }
