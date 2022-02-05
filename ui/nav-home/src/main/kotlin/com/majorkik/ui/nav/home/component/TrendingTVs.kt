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
import com.majorkik.core.ui.extension.clickableWithSimpleRipple
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.soywiz.klock.Date

@Composable
fun VerticalMovieCard(
    posterPath: String?,
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
                .background(MovieBoxTheme.colors.primary.copy(alpha = 0.2f))
                .clickableWithSimpleRipple(onClick),
        ) {
            Image(
                painter = rememberImagePainter(data = posterPath, builder = { crossfade(true) }),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            VoteAverageInPercent(voteAverage = voteAverage, modifier = Modifier.align(Alignment.TopEnd))

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
            color = MovieBoxTheme.colors.text.white,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
fun VoteAverageInPercent(voteAverage: Double, modifier: Modifier = Modifier) {
    Text(
        "${voteAverage.percentOf(from = 10)}%",
        style = MovieBoxTheme.typography.titleSmall,
        color = MovieBoxTheme.colors.text.white,
        modifier = modifier
            .padding(8.dp)
            .clip(CircleShape)
            .background(MovieBoxTheme.colors.backgroundDark50)
            .padding(vertical = 4.dp, horizontal = 8.dp)
    )
}

@Preview
@Composable
fun VerticalMovieCardPreview() {
    VerticalMovieCard(
        posterPath = null,
        title = "Demon slayer - Kimetsu on i ni n ",
        voteAverage = 7.233213,
        releaseDate = Date.invoke(year = 2021, month = 9, day = 23)
    ) {

    }
}
