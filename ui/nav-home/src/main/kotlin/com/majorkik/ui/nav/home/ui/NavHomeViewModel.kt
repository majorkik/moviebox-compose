package com.majorkik.ui.nav.home.ui

import androidx.lifecycle.ViewModel
import com.majorkik.tmdb.api.model.Genre
import com.majorkik.tmdb.api.network.NetworkResult
import com.majorkik.tmdb.api.repository.GenresRepository
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

internal class NavHomeViewModelViewModel(private val genresRepository: GenresRepository) : ViewModel(),
    ContainerHost<NavHomeViewModelViewState, NavHomeViewModelSideEffect> {

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
    }

    private fun fetchGenresIfNeed() = intent {
        if (state.genres.isEmpty()) {
            val result = if (state.isMovieGenresSelected) {
                genresRepository.getMovieGenres()
            } else {
                genresRepository.getTVGenres()
            }

            when (result) {
                is NetworkResult.Error -> { postSideEffect(NavHomeViewModelSideEffect.ShowErrorToast()) }
                is NetworkResult.Exception -> { postSideEffect(NavHomeViewModelSideEffect.ShowErrorToast()) }
                is NetworkResult.Success -> reduce {
                    if (state.isMovieGenresSelected) {
                        state.copy(isGenresLoading = false, movieGenres = result.data)
                    } else {
                        state.copy(isGenresLoading = false, tvGenres = result.data)
                    }
                }
            }
        }
    }
}

internal data class NavHomeViewModelViewState(
    val isGenresLoading: Boolean = false,
    val isMovieGenresSelected: Boolean = true,
    val movieGenres: List<Genre> = emptyList(),
    val tvGenres: List<Genre> = emptyList(),
) {
    val genres: List<Genre>
        get() = if (isMovieGenresSelected) movieGenres else tvGenres
}

internal sealed class NavHomeViewModelSideEffect {
    data class ShowErrorToast(val message: String? = null): NavHomeViewModelSideEffect()
}
