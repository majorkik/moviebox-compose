package com.majorkik.movieboxcompose.ui

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.majorkik.movie.details.ui.MovieDetailsScreen

@Composable
fun MainContainer() {
    Scaffold(backgroundColor = Color.White) {
        MovieDetailsScreen()
    }
}
