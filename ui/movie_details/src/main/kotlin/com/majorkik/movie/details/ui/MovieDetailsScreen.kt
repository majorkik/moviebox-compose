package com.majorkik.movie.details.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.majorkik.movie.details.core.DimenLocal
import com.majorkik.tmdb.api.model.MovieDetails
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
            ImagePager(
                screenState.data,
                images = screenState.data.images.posters.map { it.fullUrl })
        }
    }
}

@ExperimentalPagerApi
@Composable
internal fun ImagePager(
    movieDetails: MovieDetails,
    images: List<String>,
    initialPage: Int = 0,
    onPositionUpdate: (position: Int) -> Unit = {}
) {
    val pagerState = rememberPagerState()
    val insets = LocalWindowInsets.current
    val navigationBarBottom = with(LocalDensity.current) { insets.navigationBars.bottom.toDp() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MovieBoxTheme.colors.darkBackground)
    ) {
        HorizontalPager(count = images.count(), state = pagerState) { page ->
            onPositionUpdate(page)

            Image(
                painter = rememberImagePainter(data = images[page]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        HorizontalIndicator(count = images.count(), currentIndex = pagerState.currentPage)

        Text(
            movieDetails.title,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(horizontal = 16.dp, vertical = 16.dp + navigationBarBottom),
            style = MovieBoxTheme.typography.h1,
            color = MovieBoxTheme.colors.background
        )
    }

    LaunchedEffect(initialPage) {
        pagerState.scrollToPage(page = initialPage)
    }
}

@Composable
internal fun HorizontalIndicator(count: Int, currentIndex: Int) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val insets = LocalWindowInsets.current
    val statusBarTop = with(LocalDensity.current) { insets.statusBars.top.toDp() }

    if (count != 0 && screenWidth > 0) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(DimenLocal.Indicators.paddingDp(statusBarTop)),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            (0 until count).forEachIndexed { index, _ ->
                Box(
                    modifier = Modifier
                        .width(((screenWidth - DimenLocal.Indicators.totalHorizontalPadding) / count).dp - 2.dp)
                        .height(4.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(if (index == currentIndex) Color.White else Color.White.copy(alpha = 0.25f))
                )
            }
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true, widthDp = 375, heightDp = 812)
@Composable
fun MovieDetailsScreenPreview() {
    ImagePager(
        movieDetails = MovieDetails(
            adult = false,
            backdropPath = null,
            belongsToCollection = null,
            budget = 0,
            genres = listOf(),
            homepage = null,
            id = 0,
            imdbId = null,
            originalLanguage = "",
            originalTitle = "",
            overview = null,
            popularity = 0.0,
            posterPath = null,
            productionCompanies = listOf(),
            productionCountries = listOf(),
            releaseDate = "",
            revenue = 0,
            runtime = null,
            spokenLanguages = listOf(),
            status = "",
            tagline = null,
            title = "",
            video = false,
            voteAverage = 0.0,
            voteCount = 0,
            images = MovieDetails.Images(
                backdrops = listOf(),
                posters = listOf()
            )
        ),
        images = listOf(
            "https://www.themoviedb.org/t/p/w440_and_h660_face/M7SUK85sKjaStg4TKhlAVyGlz3.jpg",
            "https://www.themoviedb.org/t/p/w440_and_h660_face/28mcCmmVbCUMeI7MEQrCFbzUifh.jpg"
        )
    )
}
