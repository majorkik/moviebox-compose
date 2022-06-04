package com.majorkik.ui.movie.details.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.majorkik.tmdb.api.model.BackdropPath
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

private object MovieDetailsDimens {
    val contentHorizontalPadding = PaddingValues(horizontal = 16.dp)
}

@Destination(navArgsDelegate = MovieDetailsNavArgs::class)
@Composable
fun MovieDetailsScreen(navController: NavController) {
    MovieBoxContent(viewModel = getViewModel { parametersOf(navController.currentBackStackEntry) })
}

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun MovieBoxContent(viewModel: MovieDetailsViewModel) {
    val state = viewModel.container.stateFlow.collectAsState()

    when (val screenState = state.value.screen) {
        is State.MovieDetailsState -> {
            val details = screenState.data

            Column(modifier = Modifier.fillMaxSize()) {
                // Image pager
                HorizontalPager(count = details.backdrops.count()) { page ->
                    AsyncImage(
                        model = details.backdrops.getOrNull(page)
                            ?.build(size = BackdropPath.Size.Original)
                            .orEmpty(),
                        contentDescription = null,
                        modifier = Modifier
                            .height(250.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.size(16.dp))

                // Movie title
                Text(
                    text = details.title,
                    color = MovieBoxTheme.colors.text.primary,
                    style = MovieBoxTheme.typography.h2,
                    modifier = Modifier.padding(MovieDetailsDimens.contentHorizontalPadding)
                )

                Spacer(modifier = Modifier.size(8.dp))

                // Release date + status
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(MovieDetailsDimens.contentHorizontalPadding)
                ) {
                    Text(
                        text = details.releaseDate?.format("dd MMMM yyyy") ?: "Unknown",
                        color = MovieBoxTheme.colors.backgroundReverse,
                        style = MovieBoxTheme.typography.titleSmall
                    )

                    Text(
                        text = details.status,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(MovieBoxTheme.colors.backgroundReverse)
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        color = MovieBoxTheme.colors.background,
                        style = MovieBoxTheme.typography.titleSmall
                    )
                }

                Spacer(modifier = Modifier.size(16.dp))

                // Action button
                Button(
                    onClick = { /* no-op */ },
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 0.dp,
                        hoveredElevation = 0.dp,
                        focusedElevation = 0.dp
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = MovieBoxTheme.colors.primary,
                        contentColor = MovieBoxTheme.colors.white,
                        disabledContentColor = MovieBoxTheme.colors.secondary
                    )
                ) {
                    Text(
                        text = "Will watch",
                        maxLines = 1,
                        style = MovieBoxTheme.typography.titleSmall
                    )
                }

                Spacer(modifier = Modifier.size(16.dp))

                // Overview
                Text(
                    text = "Overview",
                    modifier = Modifier.padding(MovieDetailsDimens.contentHorizontalPadding),
                    color = MovieBoxTheme.colors.backgroundReverse,
                    style = MovieBoxTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = details.overview ?: "",
                    modifier = Modifier.padding(MovieDetailsDimens.contentHorizontalPadding),
                    style = MovieBoxTheme.typography.text,
                    color = MovieBoxTheme.colors.backgroundReverse
                )

                Spacer(modifier = Modifier.size(16.dp))

                // Genres
                Text(
                    text = "Genres",
                    modifier = Modifier.padding(MovieDetailsDimens.contentHorizontalPadding),
                    color = MovieBoxTheme.colors.backgroundReverse,
                    style = MovieBoxTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.size(16.dp))

                // Actors
                Text(
                    text = "Actors",
                    modifier = Modifier.padding(MovieDetailsDimens.contentHorizontalPadding),
                    color = MovieBoxTheme.colors.backgroundReverse,
                    style = MovieBoxTheme.typography.titleSmall
                )
            }
        }
        else -> {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(text = "Error state")
            }
        }
    }
}
