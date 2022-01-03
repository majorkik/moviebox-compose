package com.majorkik.ui.nav.profile.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.majorkik.app.preferences.api.MovieBoxPreferences
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class NavProfileViewModel(
    private val appPreferences: MovieBoxPreferences
) : ViewModel(), ContainerHost<HomeState, HomeSideEffect> {
    override val container: Container<HomeState, HomeSideEffect> = container(initialState = HomeState())

    fun actionSaveTheme(isDark: Boolean) {
        viewModelScope.launch {
            appPreferences.setThemeMode(isDark = isDark)
        }
    }
}

internal class HomeState

internal sealed class HomeSideEffect
