package com.majorkik.ui.movie.details.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Destination(navArgsDelegate = MovieDetailsNavArgs::class)
@Composable
fun MovieDetailsScreen(navController: NavController) {
    MovieBoxContent(viewModel = getViewModel { parametersOf(navController.currentBackStackEntry) })
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
