package com.majorkik.ui.nav.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.majorkik.core.localization.R
import com.majorkik.core.ui.CoreDrawable
import com.majorkik.core.ui.extension.clickableWithSimpleRipple
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.majorkik.core.ui.theme.MBTheme

@Composable
internal fun RoundedButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        modifier = modifier
            .clip(CircleShape)
            .background(MovieBoxTheme.colors.background.opposite)
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .clickableWithSimpleRipple(onClick),
        style = MovieBoxTheme.typography.bodyMedium,
        color = MovieBoxTheme.colors.text.primaryOnOpposite
    )
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
                painter = painterResource(id = CoreDrawable.ic_round_arrow_right_black_24),
                contentDescription = null,
                tint = MovieBoxTheme.colors.foreground.positiveAccent
            )

            Text(
                stringResource(id = R.string.nav_home_screen_login_button),
                modifier = Modifier,
                style = MovieBoxTheme.typography.h4,
                color = MovieBoxTheme.colors.text.positiveAccent
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    MBTheme {
        Column {
            RoundedButton(text = "Button") {
                /* no-op */
            }

            LoginButton {
                /* no-op */
            }
        }
    }
}
