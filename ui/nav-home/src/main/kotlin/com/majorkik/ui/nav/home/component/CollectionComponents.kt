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
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.majorkik.core.ui.extension.clickableWithSimpleRipple
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.majorkik.tmdb.api.model.Movie
import com.soywiz.klock.Date
import kotlin.math.roundToInt

@Composable
fun PopularMovieCard(
    id: Int,
    name: String,
    date: Date?,
    voteAverage: Double,
    backdropPath: String?,
    onClick: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .size(width = 300.dp, height = 150.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickableWithSimpleRipple { onClick(id) }, contentAlignment = Alignment.BottomStart
    ) {
        Image(
            painter = rememberImagePainter(
                data = backdropPath,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.2f))
        )

        Text(
            "${(voteAverage * 10).roundToInt()}%",
            style = MovieBoxTheme.typography.titleSmall,
            color = MovieBoxTheme.colors.text.white,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
                .clip(CircleShape)
                .background(MovieBoxTheme.colors.backgroundDark50)
                .padding(vertical = 4.dp, horizontal = 8.dp)
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                name,
                style = MovieBoxTheme.typography.h4,
                color = MovieBoxTheme.colors.text.white,
                maxLines = 1
            )

            if (date != null) {
                Text(
                    date.year.toString(),
                    style = MovieBoxTheme.typography.titleMedium,
                    color = MovieBoxTheme.colors.text.white
                )
            }
        }
    }
}
