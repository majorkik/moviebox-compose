package com.majorkik.movie.details.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.majorkik.tmdb.api.model.MovieDetails
import org.koin.androidx.compose.get
import java.util.*
import com.majorkik.core.ui.R as CoreRes

@Composable
fun MovieDetailsScreen(viewModel: MovieDetailsViewModel = get()) {
    val state = viewModel.container.stateFlow.collectAsState()

    if (state.value.movieDetails != null) {
        ContentDetails(state.value.movieDetails!!)
    }
}

@Composable
private fun ContentDetails(details: MovieDetails) {
    Column {
        Row {
            IconButton(onClick = {}) {
                Icon(painter = painterResource(CoreRes.drawable.ic_arrow_left), contentDescription = null)
            }

            Spacer(modifier = Modifier.fillMaxWidth())
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MovieBoxTheme.colors.secondaryBackground)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = details.title, style = MovieBoxTheme.typography.h4)

                Text(text = details.releaseDate, style = MovieBoxTheme.typography.h4)
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(ratio = 1f)
                    .background(color = Color.Black)
            )

            Text(
                text = "The Movie Database\n${details.voteAverage * 100}% of ${details.voteCount} ratings",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                style = MovieBoxTheme.typography.h4,
                maxLines = Int.MAX_VALUE
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(modifier = Modifier.weight(weight = 1f), text = "Year: ${details.releaseDate}")

            Spacer(modifier = Modifier.size(16.dp))

            Text(text = details.genres.joinToString(", ") { it.name.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.getDefault()
                ) else it.toString()
            } })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailsScreenPreview() {
    MovieDetailsScreen()
}
