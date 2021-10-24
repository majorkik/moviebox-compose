package com.majorkik.movie.details

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.majorkik.core.ui.R as CoreRes

@Composable
fun MovieDetailsScreen() {
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
                Text(text = "John Wick 3: Parabellum", style = MovieBoxTheme.typography.h4)

                Text(text = "2021", style = MovieBoxTheme.typography.h4)
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(ratio = 1f)
                    .background(color = Color.Black)
            )

            Text(
                text = "The Movie Database\n78% of 283,324 ratings",
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
            Text(modifier = Modifier.weight(weight = 1f), text = "Year: 2021")

            Spacer(modifier = Modifier.size(16.dp))

            Text(text = "Genres: Action, Fantasy")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailsScreenPreview() {
    MovieDetailsScreen()
}
