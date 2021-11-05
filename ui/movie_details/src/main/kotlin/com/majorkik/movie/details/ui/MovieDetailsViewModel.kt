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

class MovieDetailsViewModel(private val repository: MovieDetailsRepository) : ViewModel(),
    ContainerHost<MovieDetailsViewState, MovieDetailsSideEffect> {
    override val container: Container<MovieDetailsViewState, MovieDetailsSideEffect> =
        container(MovieDetailsViewState()) { state ->
            if (state.movieDetails == null) {
                actionFetchMovieDetails(id = 245_891)
            }
        }

    private fun actionFetchMovieDetails(id: Long) = intent {
        actionStartLoading()

        when (val result = repository.fetchMovieDetails(id = id)) {
            is NetworkResult.Success -> reduce {
                state.copy(isLoading = false, movieDetails = result.data)
            }

            is NetworkResult.Error -> {

            }

            is NetworkResult.Exception -> {

            }
        }

        actionStopLoading()
    }

    private fun actionStartLoading() = intent {
        reduce { state.copy(isLoading = true) }
    }

    private fun actionStopLoading() = intent {
        reduce { state.copy(isLoading = false) }
    }
}

data class MovieDetailsViewState(
    val isLoading: Boolean = true,
    val movieDetails: MovieDetails? = null
)

sealed class MovieDetailsSideEffect
