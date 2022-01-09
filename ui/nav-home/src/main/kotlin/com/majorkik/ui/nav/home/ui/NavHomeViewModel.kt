package com.majorkik.ui.nav.home.ui

import androidx.lifecycle.ViewModel
import com.majorkik.tmdb.api.model.Genre
import com.orhanobut.logger.Logger
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

internal class NavHomeViewModelViewModel : ViewModel(),
    ContainerHost<NavHomeViewModelViewState, NavHomeViewModelSideEffect> {

    override val container =
        container<NavHomeViewModelViewState, NavHomeViewModelSideEffect>(NavHomeViewModelViewState())

    fun changeMovieGenres(isMovieGenresSelected: Boolean) = intent {
        Logger.d(isMovieGenresSelected)
        reduce {
            state.copy(isMovieGenresSelected = isMovieGenresSelected)
        }
    }
}

internal data class NavHomeViewModelViewState(
    val isMovieGenresSelected: Boolean = true,
    val movieGenres: List<Genre> = emptyList(),
    val tvGenres: List<Genre> = emptyList(),
)

internal sealed class NavHomeViewModelSideEffect
