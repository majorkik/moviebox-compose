package com.majorkik.movie.details.ui

import androidx.lifecycle.ViewModel
import com.majorkik.tmdb.api.model.MovieDetails
import com.majorkik.tmdb.api.network.NetworkResult
import com.majorkik.tmdb.api.repository.MovieDetailsRepository
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

internal class MovieDetailsViewModel(
    private val repository: MovieDetailsRepository
    ) : ViewModel(), ContainerHost<MovieDetailsViewState, MovieDetailsSideEffect> {
    // Initialization container
    override val container: Container<MovieDetailsViewState, MovieDetailsSideEffect> =
        container(MovieDetailsViewState()) { state ->
            if (state.screen !is State.MovieDetailsState) { actionFetchMovieDetails(id = 245_891) }
        }

    private fun actionFetchMovieDetails(id: Long) = intent {
        when (val result = repository.fetchMovieDetails(id = id)) {
            is NetworkResult.Success -> reduce { state.copy(screen = State.MovieDetailsState(data = result.data)) }

            is NetworkResult.Error ->  reduce { state.copy(screen = State.ErrorState) }

            is NetworkResult.Exception ->  reduce { state.copy(screen = State.ErrorState) }
        }
    }
}

internal sealed class State {
    object LoadingState : State()
    object ErrorState : State()
    data class MovieDetailsState(val data: MovieDetails) : State()
}

internal data class MovieDetailsViewState(
    val screen: State = State.LoadingState
)

internal sealed class MovieDetailsSideEffect
