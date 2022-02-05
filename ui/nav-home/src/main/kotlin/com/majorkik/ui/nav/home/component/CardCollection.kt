package com.majorkik.ui.nav.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.majorkik.common.percentOf
import com.majorkik.core.ui.extension.clickableWithSimpleRipple
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.majorkik.tmdb.api.model.Movie

@Composable
internal fun PopularMovieCard(
    movie: Movie,
    onClick: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .size(width = 300.dp, height = 150.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickableWithSimpleRipple { onClick(movie.id) }, contentAlignment = Alignment.BottomStart
    ) {
        // Image
        Image(
            painter = rememberImagePainter(data = movie.backdropPath, builder = { crossfade(true) }),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.2f))
        )

        // Rating as a percentage
        Text(
            "${movie.voteAverage.percentOf(from = 10)}%",
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
                movie.title,
                style = MovieBoxTheme.typography.h4,
                color = MovieBoxTheme.colors.text.white,
                maxLines = 1
            )

            if (movie.releaseDate != null) {
                Text(
                    movie.releaseDate!!.year.toString(),
                    style = MovieBoxTheme.typography.titleMedium,
                    color = MovieBoxTheme.colors.text.white
                )
            }
        }
    }
}