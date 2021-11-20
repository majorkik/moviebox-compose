package com.majorkik.movie.details.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.majorkik.movie.details.core.DimenLocal
import com.majorkik.movie.details.core.HorizontalIndicator
import com.majorkik.movie.details.core.ImagePager
import com.majorkik.tmdb.api.model.MovieDetails
import com.majorkik.tmdb.api.util.DateUtil
import org.koin.androidx.compose.get

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MovieDetailsScreen() {
    MovieBoxContent()
}


@ExperimentalPagerApi
@Composable
internal fun MovieBoxContent(viewModel: MovieDetailsViewModel = get()) {
    val state = viewModel.container.stateFlow.collectAsState()

    when (val screenState = state.value.screen) {
        is State.MovieDetailsState -> {
            Details(screenState.data)
        }
    }
}

@ExperimentalPagerApi
@Composable
internal fun Details(details: MovieDetails) {
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MovieBoxTheme.colors.background)
    ) {
        Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.weight(1f)) {
            ImagePager(modifier = Modifier.fillMaxSize(), pagerState = pagerState, imageLinks = details.posterLinks)

            HorizontalIndicator(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(DimenLocal.Indicators.padding),
                count = details.posterLinks.count(),
                currentIndex = pagerState.currentPage
            )
        }

        Row(
            modifier = Modifier
                .background(MovieBoxTheme.colors.background)
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(DimenLocal.footerPadding)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = details.title,
                    style = MovieBoxTheme.typography.h1,
                    color = MovieBoxTheme.colors.text.primary
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (details.releaseDate != null) {
                        Text(
                            text = details.releaseDate!!.format(DateUtil.READABLE_DATE_PATTERN),
                            style = MovieBoxTheme.typography.h4,
                            color = MovieBoxTheme.colors.text.secondary
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        details.status,
                        style = MovieBoxTheme.typography.smallBold,
                        color = MovieBoxTheme.colors.text.secondary,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(MovieBoxTheme.colors.secondaryBackground)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MovieBoxTheme.colors.backgroundReverse),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "${details.voteAverage}",
                    style = MovieBoxTheme.typography.smallBold,
                    color = MovieBoxTheme.colors.background,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true, widthDp = 375, heightDp = 812)
@Composable
fun MovieDetailsScreenPreview() {
    Details(details = MovieDetails.mock())
}
