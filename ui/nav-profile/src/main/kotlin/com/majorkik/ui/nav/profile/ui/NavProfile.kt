package com.majorkik.ui.nav.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.majorkik.core.ui.R
import com.majorkik.core.ui.theme.MovieBoxTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun NavProfileScreen() {
    NavProfileContent(viewModel = getViewModel())
}

@Composable
internal fun NavProfileContent(viewModel: NavProfileViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MovieBoxTheme.colors.background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            ThemeButton(
                MovieBoxTheme.colors.isLight.not(),
                onChangeTheme = viewModel::actionSaveTheme
            )
        }
    }
}

@Composable
internal fun ThemeButton(
    isDark: Boolean,
    onChangeTheme: (Boolean) -> Unit = {}
) {
    IconToggleButton(
        checked = isDark,
        onCheckedChange = onChangeTheme
    ) {
        if (isDark) {
            Icon(
                painter = painterResource(id = R.drawable.ic_light_mode_black_24dp),
                contentDescription = null,
                tint = MovieBoxTheme.colors.themeColor
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.ic_dark_mode_black_24),
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
        NavProfileContent(viewModel = getViewModel())
    }
}
