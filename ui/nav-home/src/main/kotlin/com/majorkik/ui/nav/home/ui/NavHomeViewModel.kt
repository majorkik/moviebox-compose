package com.majorkik.ui.nav.home.ui

import androidx.lifecycle.ViewModel
import com.majorkik.tmdb.api.model.Genre
import com.majorkik.tmdb.api.model.Movie
import com.majorkik.tmdb.api.network.NetworkResult
import com.majorkik.tmdb.api.repository.GenresRepository
import com.majorkik.tmdb.api.repository.MoviesRepository
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

internal class NavHomeViewModelViewModel(
    private val genresRepository: GenresRepository,
    private val moviesRepository: MoviesRepository
) : ViewModel(), ContainerHost<NavHomeViewModelViewState, NavHomeViewModelSideEffect> {

    override val container: Container<NavHomeViewModelViewState, NavHomeViewModelSideEffect> =
        container(NavHomeViewModelViewState()) {
            initLoadingData()
        }

    fun toggleGenresMode() = intent {
        reduce { state.copy(isMovieGenresSelected = state.isMovieGenresSelected.not()) }

        fetchGenresIfNeed()
    }

    private fun initLoadingData() = intent {
        reduce { state.copy(isGenresLoading = true) }

        fetchGenresIfNeed()
        fetchPopularMovies()
    }

    private fun fetchGenresIfNeed() {
        intent {
            if (state.genres.isNotEmpty()) return@intent

            val result = if (state.isMovieGenresSelected) {
                genresRepository.getMovieGenres()
            } else {
                genresRepository.getTVGenres()
            }

            when (result) {
                is NetworkResult.Success -> reduce {
                    if (state.isMovieGenresSelected) {
                        state.copy(isGenresLoading = false, movieGenres = result.data)
                    } else {
                        state.copy(isGenresLoading = false, tvGenres = result.data)
                    }
                }
                else -> postSideEffect(NavHomeViewModelSideEffect.ShowErrorToast())
            }
        }
    }

    private fun fetchPopularMovies() = intent {
        val currentPage: Int = state.popularMoviesState.currentPage
        val totalPages: Int? = state.popularMoviesState.totalPages

        if (totalPages != null && currentPage >= totalPages) return@intent

        val nextPage: Int = if (totalPages == null) 1 else currentPage.plus(1)

        when (val result = moviesRepository.getPopularMovies(nextPage)) {
            is NetworkResult.Success -> reduce {
                state.copy(
                    popularMoviesState = state.popularMoviesState.copy(
                        currentPage = result.data.page,
                        movies = result.data.movies,
                        totalPages = result.data.totalPages
                    )
                )
            }

            else -> postSideEffect(NavHomeViewModelSideEffect.ShowErrorToast())
        }
    }
}

internal data class NavHomeViewModelViewState(
    val isGenresLoading: Boolean = false,
    val isMovieGenresSelected: Boolean = true,
    val movieGenres: List<Genre> = emptyList(),
    val tvGenres: List<Genre> = emptyList(),
    val popularMoviesState: MovieCollectionState = MovieCollectionState()
) {
    val genres: List<Genre>
        get() = if (isMovieGenresSelected) movieGenres else tvGenres
}

internal sealed class NavHomeViewModelSideEffect {
    data class ShowErrorToast(val message: String? = null) : NavHomeViewModelSideEffect()
}

internal data class MovieCollectionState(
    val currentPage: Int = 1,
    val movies: List<Movie> = listOf(),
    val totalPages: Int? = null,
)
