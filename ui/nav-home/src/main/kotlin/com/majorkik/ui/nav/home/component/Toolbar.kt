package com.majorkik.ui.nav.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.majorkik.core.ui.R
import com.majorkik.core.ui.extension.clickableWithSimpleRipple
import com.majorkik.core.ui.theme.MovieBoxTheme


@Composable
internal fun Toolbar(onLoginClick: () -> Unit, onOpenSettings: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LoginButton(onLoginClick)

        IconButton(onClick = onOpenSettings) {
            Icon(
                painter = painterResource(id = R.drawable.ic_nut_bolt_black_24),
                contentDescription = null,
                tint = MovieBoxTheme.colors.backgroundReverse
            )
        }
    }
}

@Composable
internal fun LoginButton(onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .clip(CircleShape)
            .clickableWithSimpleRipple(onClick),
        elevation = 0.dp,
        color = Color.Transparent
    ) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_round_arrow_right_black_24),
                contentDescription = null,
                tint = MovieBoxTheme.colors.accent
            )

            Text(
                stringResource(id = R.string.nav_home_screen_login_button),
                modifier = Modifier,
                style = MovieBoxTheme.typography.h4,
                color = MovieBoxTheme.colors.accent
            )
        }
    }
}