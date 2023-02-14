package com.majorkik.ui.authorization.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.majorkik.core.localization.StringResource
import com.majorkik.core.ui.CoreDrawable
import com.majorkik.core.ui.components.button.MBPasswordTextField
import com.majorkik.core.ui.components.button.MBTextField
import com.majorkik.core.ui.theme.MBTheme
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.getViewModel

@Destination
@Composable
fun AuthScreen(navigator: AuthNavigator) {
    val viewModel: AuthViewModel = getViewModel()
    val viewState by viewModel.container.stateFlow.collectAsState()

    AuthContent(
        state = viewState,
        onBackPress = navigator::navigateUp,
        updateLogin = viewModel::actionUpdateLogin,
        updatePassword = viewModel::actionUpdatePassword
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AuthContent(
    state: AuthViewState,
    onBackPress: () -> Unit,
    updateLogin: (String) -> Unit,
    updatePassword: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(MBTheme.colors.background.base)
    ) {
        Column {
            MovieCards(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(StringResource.app_title).uppercase(),
                style = MBTheme.typography.ui.logoLarge,
                color = MBTheme.colors.text.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
                Spacer(modifier = Modifier.weight(1f))

                MBTextField(
                    value = state.login,
                    hint = "Enter your login",
                    onValueChange = updateLogin,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MBPasswordTextField(
                        value = state.password,
                        hint = "Enter your password",
                        onValueChange = updatePassword,
                        modifier = Modifier.weight(1f),
                    )

                    Surface(
                        onClick = {},
                        shape = RoundedCornerShape(16.dp),
                        color = MBTheme.colors.background.accent,
                        modifier = Modifier.size(48.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                painter = painterResource(id = CoreDrawable.ic_arrow_right_24),
                                tint = MBTheme.colors.foreground.onDark,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                Divider(color = MBTheme.colors.foreground.divider)

                FooterButton { /** TODO */ }
            }
        }

        IconButton(onClick = onBackPress, modifier = Modifier.align(Alignment.TopStart)) {
            Icon(
                painter = painterResource(id = CoreDrawable.ic_arrow_left_24),
                contentDescription = null,
                tint = MBTheme.colors.background.opposite
            )
        }
    }
}

@Composable
private fun MovieCards(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = CoreDrawable.image_sample_card_3_small),
            contentDescription = null,
            modifier = Modifier
                .offset(x = (-50).dp, y = 20.dp)
                .rotate(-15f)
                .shadow(elevation = 12.dp)
                .clip(RoundedCornerShape(12.dp))
                .size(width = 120.dp, height = 200.dp),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(id = CoreDrawable.image_sample_card_2_small),
            contentDescription = null,
            modifier = Modifier
                .shadow(elevation = 12.dp)
                .clip(RoundedCornerShape(12.dp))
                .size(width = 120.dp, height = 200.dp),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(id = CoreDrawable.image_sample_card_1_small),
            contentDescription = null,
            modifier = Modifier
                .offset(x = 50.dp, y = 20.dp)
                .rotate(15f)
                .shadow(elevation = 12.dp)
                .clip(RoundedCornerShape(12.dp))
                .size(width = 120.dp, height = 200.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FooterButton(onClick: () -> Unit) {
    val text = buildAnnotatedString {
        pushStyle(SpanStyle(color = MBTheme.colors.text.primary))

        append(stringResource(StringResource.auth_what_is))

        withStyle(style = SpanStyle(color = MBTheme.colors.text.tmdbBrand)) {
            append(" " + stringResource(StringResource.tmdb_full_title))
        }

        append("?")
    }

    Surface(onClick = {}, color = Color.Transparent) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(
                text = text,
                modifier = Modifier,
                textAlign = TextAlign.Center,
                style = MBTheme.typography.body.textMedium
            )
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "AuthScreen DARK")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO, name = "AuthScreen LIGHT")
@Composable
private fun AuthContentPreview() {
    MBTheme() {
        AuthContent(
            state = AuthViewState(),
            onBackPress = {},
            updateLogin = {},
            updatePassword = {}
        )
    }
}
