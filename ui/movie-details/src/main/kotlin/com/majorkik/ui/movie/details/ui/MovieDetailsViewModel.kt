package com.majorkik.ui.movie.details.ui

import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import com.majorkik.tmdb.api.model.MovieDetails
import com.majorkik.tmdb.api.network.NetworkResult
import com.majorkik.tmdb.api.repository.MovieDetailsRepository
import com.majorkik.ui.movie.details.ui.destinations.MovieDetailsScreenDestination
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class MovieDetailsViewModel(
    navBackStackEntry: NavBackStackEntry,
    private val repository: MovieDetailsRepository
) : ViewModel(), ContainerHost<MovieDetailsViewState, MovieDetailsSideEffect> {
    // Arguments
    private val args = MovieDetailsScreenDestination.argsFrom(navBackStackEntry)

    // Initialization container
    override val container: Container<MovieDetailsViewState, MovieDetailsSideEffect> =
        container(MovieDetailsViewState()) { state ->
            if (state.screen !is State.MovieDetailsState) {
                actionFetchMovieDetails(id = args.movieId)
            }
        }

    private fun actionFetchMovieDetails(id: Int) = intent {
        when (val result = repository.fetchMovieDetails(id = id)) {
            is NetworkResult.Success -> reduce { state.copy(screen = State.MovieDetailsState(data = result.data)) }
            is NetworkResult.Error -> reduce { state.copy(screen = State.ErrorState) }
            is NetworkResult.Exception -> reduce { state.copy(screen = State.ErrorState) }
        }
    }
}

sealed class State {
    object LoadingState : State()
    object ErrorState : State()
    data class MovieDetailsState(val data: MovieDetails) : State()
}

data class MovieDetailsViewState(
    val screen: State = State.LoadingState
)

sealed class MovieDetailsSideEffect
