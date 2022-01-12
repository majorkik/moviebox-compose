package com.majorkik.ui.nav.home.ui

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.majorkik.core.ui.extension.clickableWithSimpleRipple
import com.majorkik.core.ui.extension.showToast
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.majorkik.tmdb.api.model.Genre
import com.majorkik.ui.nav.home.component.AppStaticSwitch
import com.majorkik.ui.nav.home.component.LoginButton
import com.majorkik.ui.nav.home.component.RoundedButton
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import com.majorkik.core.ui.R as CoreRes

@Composable
fun NavHomeScreen() {
    NavHomeContent(viewModel = getViewModel())
}

@Composable
internal fun NavHomeContent(viewModel: NavHomeViewModelViewModel) {
    val context = LocalContext.current
    val state = viewModel.container.stateFlow.collectAsState()

    LaunchedEffect(viewModel) {
        launch {
            viewModel.container.sideEffectFlow.collectLatest { sideEffect ->
                handleSideEffect(sideEffect = sideEffect, context = context)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Toolbar()

        GenresBlock(
            genres = state.value.genres,
            isMovieGenresSelected = state.value.isMovieGenresSelected,
            onToggleSwitch = (viewModel::toggleGenresMode),
            onGenreClick = { genreId ->
                // Navigate to search with selected genre
            })
    }
}

private fun handleSideEffect(sideEffect: NavHomeViewModelSideEffect, context: Context) {
    when (sideEffect) {
        is NavHomeViewModelSideEffect.ShowErrorToast -> {
            if (sideEffect.message == null) {
                context.showToast(CoreRes.string.error_something_went_wrong)
            } else {
                context.showToast(message = sideEffect.message)
            }
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
        LoginButton {}

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
fun GenresBlock(
    genres: List<Genre>,
    isMovieGenresSelected: Boolean,
    onToggleSwitch: () -> Unit,
    onGenreClick: (Int) -> Unit
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
                style = MovieBoxTheme.typography.h3,
                color = MovieBoxTheme.colors.backgroundReverse
            )

            GenresSwitchBox(isMovieGenresSelected = isMovieGenresSelected, onToggleSwitch = onToggleSwitch)
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(genres) { genre ->
                RoundedButton(text = genre.name) { onGenreClick(genre.id) }
            }
        }
    }
}

@Composable
internal fun GenresSwitchBox(isMovieGenresSelected: Boolean, onToggleSwitch: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
        modifier = Modifier
            .clip(CircleShape)
            .clickableWithSimpleRipple(onToggleSwitch)
    ) {
        Text(
            text = stringResource(id = CoreRes.string.movie),
            style = MovieBoxTheme.typography.titleMedium,
            color = if (isMovieGenresSelected) {
                MovieBoxTheme.colors.backgroundReverse
            } else {
                MovieBoxTheme.colors.secondaryBackground
            }
        )

        AppStaticSwitch(checked = isMovieGenresSelected.not())

        Text(
            text = stringResource(id = CoreRes.string.tv),
            style = MovieBoxTheme.typography.titleMedium,
            color = if (isMovieGenresSelected.not()) {
                MovieBoxTheme.colors.backgroundReverse
            } else {
                MovieBoxTheme.colors.secondaryBackground
            }
        )
    }
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
                isMovieGenresSelected = true,
                onToggleSwitch = {},
                onGenreClick = {}
            )
        }
    }
}
