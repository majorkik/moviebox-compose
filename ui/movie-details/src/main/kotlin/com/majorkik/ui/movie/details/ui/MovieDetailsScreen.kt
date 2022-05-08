package com.majorkik.ui.movie.details.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.getViewModel

@Destination
@Composable
fun MovieDetailsScreen() {
    MovieBoxContent(viewModel = getViewModel())
}

@Composable
internal fun MovieBoxContent(viewModel: MovieDetailsViewModel) {
    val state = viewModel.container.stateFlow.collectAsState()

    when (val screenState = state.value.screen) {
        is State.MovieDetailsState -> {
            Text("Movie: ${screenState.data.originalTitle}")
        }
        else -> {
            Text("Error state")
        }
    }
}
