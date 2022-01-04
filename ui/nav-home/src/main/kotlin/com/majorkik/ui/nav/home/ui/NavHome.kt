package com.majorkik.ui.nav.home.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.majorkik.core.ui.theme.MovieBoxTheme

@Composable
fun NavHomeScreen() {
    NavHomeContent()
}

@Composable
internal fun NavHomeContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            LoginButton(textResId = com.majorkik.core.ui.R.string.nav_home_screen_login_button) {}

            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = com.majorkik.core.ui.R.drawable.ic_nut_bolt_black_24),
                    contentDescription = null,
                    tint = MovieBoxTheme.colors.backgroundReverse
                )
            }
        }
    }
}

@Composable
internal fun LoginButton(@StringRes textResId: Int, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(percent = 100))
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = rememberRipple(),
                onClick = onClick
            ),
        elevation = 0.dp,
        color = Color.Transparent
    ) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = com.majorkik.core.ui.R.drawable.ic_round_arrow_right_black_24),
                contentDescription = null,
                tint = MovieBoxTheme.colors.accent
            )

            Text(
                stringResource(id = textResId),
                modifier = Modifier,
                style = MovieBoxTheme.typography.h4,
                color = MovieBoxTheme.colors.accent
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    NavHomeContent()
}
