package com.majorkik.movieboxcompose.ui

import androidx.lifecycle.ViewModel
import com.majorkik.app.preferences.api.MovieBoxPreferences
import kotlinx.coroutines.flow.Flow

internal class MainActivityViewModel(appPreferences: MovieBoxPreferences) : ViewModel() {
    val shouldUseDarkTheme: Flow<Boolean> = appPreferences.shouldUseDarkTheme
}
