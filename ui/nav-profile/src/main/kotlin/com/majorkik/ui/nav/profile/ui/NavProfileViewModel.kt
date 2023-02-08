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
) : ViewModel(), ContainerHost<ProfileState, ProfileSideEffect> {
    override val container: Container<ProfileState, ProfileSideEffect> = container(initialState = ProfileState())

    fun actionSaveTheme(isDark: Boolean) {
        viewModelScope.launch {
            appPreferences.setThemeMode(isDark = isDark)
        }
    }
}

internal class ProfileState

internal sealed class ProfileSideEffect
