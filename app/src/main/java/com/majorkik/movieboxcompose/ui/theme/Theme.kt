package com.majorkik.movieboxcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color
import com.majorkik.movieboxcompose.ui.utils.LocalSysUiController

class MovieBoxColors(
    primary: Color,
    background: Color,
    isDark: Boolean
) {
    var primary by mutableStateOf(primary, structuralEqualityPolicy())
        internal set

    var background by mutableStateOf(background, structuralEqualityPolicy())
        internal set

    var isDark by mutableStateOf(isDark)
        internal set

    fun update(other: MovieBoxColors) {
        primary = other.primary
        background = other.background
        isDark = other.isDark
    }
}

object MovieBoxTheme {
    val colors: MovieBoxColors
        @Composable
        @ReadOnlyComposable
        get() = LocalMovieBoxColors.current
}

internal val LocalMovieBoxColors = staticCompositionLocalOf<MovieBoxColors> {
    error("No MovieBoxColorsPalette provided")
}

@Composable
fun MovieBoxTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) darkColors() else lightColors()

    val sysUiController = LocalSysUiController.current

    SideEffect {
        sysUiController.setSystemBarsColor(
            color = colors.background.copy(alpha = AlphaNearOpaque)
        )
    }

    ProvideMovieBoxColors(colors) {
        MaterialTheme(
            colors = debugColors(darkTheme),
            shapes = Shapes,
            content = content
        )
    }
}

@Composable
fun ProvideMovieBoxColors(
    colors: MovieBoxColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember { colors }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalMovieBoxColors provides colorPalette, content = content)
}
