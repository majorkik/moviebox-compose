package com.majorkik.ui.nav.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.majorkik.core.ui.R
import com.majorkik.core.ui.extension.clickableWithSimpleRipple
import com.majorkik.core.ui.theme.MovieBoxTheme

@Composable
internal fun RoundedButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        modifier = modifier
            .clip(CircleShape)
            .background(MovieBoxTheme.colors.backgroundReverse)
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .clickableWithSimpleRipple(onClick),
        style = MovieBoxTheme.typography.bodyMedium,
        color = MovieBoxTheme.colors.background
    )
}
