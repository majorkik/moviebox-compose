package com.majorkik.ui.nav.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.majorkik.common.percentOf
import com.majorkik.core.ui.components.getPopcornPlaceholderResId
import com.majorkik.core.ui.extension.clickableWithSimpleRipple
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.majorkik.tmdb.api.model.BackdropPath
import com.majorkik.tmdb.api.model.PosterPath
import com.soywiz.klock.Date
import com.soywiz.klock.DateTime

@Composable
internal fun HorizontalMovieCard(
    backdropPath: BackdropPath?,
    title: String,
    voteAverage: Double,
    releaseDate: Date?,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(width = 300.dp, height = 150.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(MovieBoxTheme.colors.placeholder.backgroundDark)
            .clickableWithSimpleRipple(onClick),
        contentAlignment = Alignment.BottomStart
    ) {
        // Image
        Image(
            painter = rememberImagePainter(
                data = backdropPath?.build(size = BackdropPath.Size.Width1280),
                builder = {
                    crossfade(true)
                    placeholder(getPopcornPlaceholderResId(MovieBoxTheme.colors.isLight))
                    error(getPopcornPlaceholderResId(MovieBoxTheme.colors.isLight))
                    fallback(getPopcornPlaceholderResId(MovieBoxTheme.colors.isLight))
                }
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Rating as a percentage
        Text(
            "${voteAverage.percentOf(from = 10)}%",
            style = MovieBoxTheme.typography.titleSmall,
            color = MovieBoxTheme.colors.text.white,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
                .clip(CircleShape)
                .background(MovieBoxTheme.colors.backgroundDark50)
                .padding(vertical = 4.dp, horizontal = 8.dp)
        )

        // Title and year of release
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                title,
                style = MovieBoxTheme.typography.h4,
                color = MovieBoxTheme.colors.text.white,
                maxLines = 1
            )

            if (releaseDate != null) {
                Text(
                    releaseDate.year.toString(),
                    style = MovieBoxTheme.typography.titleMedium,
                    color = MovieBoxTheme.colors.text.white
                )
            }
        }
    }
}


@Composable
internal fun VerticalMovieCard(
    posterPath: PosterPath?,
    title: String,
    voteAverage: Double,
    releaseDate: Date?,
    onClick: () -> Unit,
) {
    Column(modifier = Modifier.width(200.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(310.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(MovieBoxTheme.colors.placeholder.background)
                .clickableWithSimpleRipple(onClick),
        ) {
            Image(
                painter = rememberImagePainter(
                    data = posterPath?.build(size = PosterPath.Size.Width500),
                    builder = {
                        crossfade(true)
                        placeholder(getPopcornPlaceholderResId(MovieBoxTheme.colors.isLight))
                        error(getPopcornPlaceholderResId(MovieBoxTheme.colors.isLight))
                        fallback(getPopcornPlaceholderResId(MovieBoxTheme.colors.isLight))
                    }
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            PercentVoteAverageText(voteAverage = voteAverage, modifier = Modifier.align(Alignment.TopEnd))

            if (releaseDate != null) {
                Text(
                    text = releaseDate.year.toString(),
                    style = MovieBoxTheme.typography.titleSmall,
                    color = MovieBoxTheme.colors.text.white,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(MovieBoxTheme.colors.secondary)
                        .padding(vertical = 4.dp, horizontal = 8.dp)
                )
            }
        }

        Text(
            text = title,
            style = MovieBoxTheme.typography.h4,
            color = MovieBoxTheme.colors.text.primary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    MovieBoxTheme {
        Column {
            HorizontalMovieCard(
                backdropPath = null,
                title = "Dune",
                voteAverage = 9.23,
                releaseDate = DateTime.now().date
            ) {}

            VerticalMovieCard(
                posterPath = null,
                title = "Dune",
                voteAverage = 9.23,
                releaseDate = DateTime.now().date
            ) {}
        }
    }
}
