package com.majorkik.ui.details.ui

import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import arrow.core.Either
import com.majorkik.tmdb.api.model.MovieDetails
import com.majorkik.tmdb.api.repository.MovieDetailsRepository
import com.majorkik.ui.details.ui.destinations.MovieDetailsScreenDestination
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
        when (val result = repository.getMovieDetailsById(id = id)) {
            is Either.Left -> reduce {
                state.copy(screen = State.ErrorState)
            }
            is Either.Right -> reduce {
                state.copy(screen = State.MovieDetailsState(data = result.value))
            }
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

