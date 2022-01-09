package com.majorkik.ui.nav.home.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.majorkik.core.ui.R as CoreRes
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.majorkik.tmdb.api.model.Genre
import com.majorkik.ui.nav.home.component.CustomSwitch
import org.koin.androidx.compose.getViewModel

@Composable
fun NavHomeScreen() {
    NavHomeContent(viewModel = getViewModel())
}

@Composable
internal fun NavHomeContent(viewModel: NavHomeViewModelViewModel) {
    val state = viewModel.container.stateFlow.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Toolbar()

        GenresBlock(
            genres = if (state.value.isMovieGenresSelected) state.value.movieGenres else state.value.tvGenres,
            isMovieGenresSelected = state.value.isMovieGenresSelected
        ) { isMovieGenresSelected ->
            viewModel.changeMovieGenres(isMovieGenresSelected)
        }
    }
}

@Composable
internal fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LoginButton(textResId = CoreRes.string.nav_home_screen_login_button) {}

        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(id = CoreRes.drawable.ic_nut_bolt_black_24),
                contentDescription = null,
                tint = MovieBoxTheme.colors.backgroundReverse
            )
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
                painter = painterResource(id = CoreRes.drawable.ic_round_arrow_right_black_24),
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

@Composable
fun GenresBlock(
    genres: List<Genre>,
    isMovieGenresSelected: Boolean,
    onGenresModeChanged: (isMovieGenresSelected: Boolean) -> Unit
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Text(
                text = stringResource(id = CoreRes.string.genres),
                style = MovieBoxTheme.typography.h4,
                color = MovieBoxTheme.colors.backgroundReverse
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
            ) {
                Text(
                    text = stringResource(id = CoreRes.string.movie),
                    style = MovieBoxTheme.typography.titleSmall,
                    color = if (isMovieGenresSelected) {
                        MovieBoxTheme.colors.backgroundReverse
                    } else {
                        MovieBoxTheme.colors.secondaryBackground
                    }
                )

                CustomSwitch(
                    checked = isMovieGenresSelected.not(),
                    trackWidth = 24.dp,
                    trackHeight = 12.dp,
                    thumbSize = 8.dp,
                    gap = 2.dp,
                    checkedThumbColor = MovieBoxTheme.colors.backgroundReverse,
                    uncheckedThumbColor = MovieBoxTheme.colors.backgroundReverse,
                    checkedTrackColor = MovieBoxTheme.colors.secondaryBackground,
                    uncheckedTrackColor = MovieBoxTheme.colors.secondaryBackground
                ) { checked ->
                    onGenresModeChanged(checked.not())
                }

                Text(
                    text = stringResource(id = CoreRes.string.tv),
                    style = MovieBoxTheme.typography.titleSmall,
                    color = if (isMovieGenresSelected.not()) {
                        MovieBoxTheme.colors.backgroundReverse
                    } else {
                        MovieBoxTheme.colors.secondaryBackground
                    }
                )
            }
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(genres) { genre ->
                RoundedButton(text = genre.name) {

                }
            }
        }
    }
}

@Composable
fun RoundedButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Text(
        text = text, textAlign = TextAlign.Center,
        modifier = modifier
            .clip(RoundedCornerShape(percent = 100))
            .background(MovieBoxTheme.colors.backgroundReverse)
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = rememberRipple(),
                onClick = onClick
            ),
        style = MovieBoxTheme.typography.bodySmall,
        color = MovieBoxTheme.colors.background
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MovieBoxTheme(isDark = true) {
        Surface(
            color = MovieBoxTheme.colors.background, modifier = Modifier
                .fillMaxWidth()
        ) {
            GenresBlock(
                genres = listOf(
                    Genre(id = 1, name = "Action"),
                    Genre(id = 2, name = "Adventure"),
                    Genre(id = 3, name = "Science Fiction")
                ),
                isMovieGenresSelected = true
            ) {

            }
        }
    }
}
