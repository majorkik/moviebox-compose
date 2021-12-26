package com.majorkik.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.majorkik.core.ui.R as CoreRes

@Composable
fun HomeScreen() {
    HomeContent()
}

@Composable
internal fun HomeContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MovieBoxTheme.colors.background)
    ) {
        Row {
            ThemeButton(MovieBoxTheme.colors.isLight) { isLight ->

            }
        }
    }
}

@Composable
internal fun ThemeButton(
    isLight: Boolean,
    onChangeTheme: (Boolean) -> Unit = {}
) {
    IconButton(onClick = { onChangeTheme(isLight) }) {
        if (isLight) {
            Icon(
                painter = painterResource(id = CoreRes.drawable.ic_light_mode_black_24dp),
                contentDescription = null,
                tint = MovieBoxTheme.colors.themeColor
            )
        } else {
            Icon(
                painter = painterResource(id = CoreRes.drawable.ic_dark_mode_black_24),
                contentDescription = null,
                tint = MovieBoxTheme.colors.themeColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun HomeContentPreview() {
    MovieBoxTheme(isDark = true) {
        HomeContent()
    }
}
