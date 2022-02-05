package com.majorkik.ui.nav.home.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.majorkik.core.ui.theme.MovieBoxTheme

@Composable
fun Header(@StringRes titleResId: Int) {
    Text(
        text = stringResource(id = titleResId),
        style = MovieBoxTheme.typography.h3,
        color = MovieBoxTheme.colors.text.primary,
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    )
}
