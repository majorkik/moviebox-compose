package com.majorkik.movieboxcompose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.majorkik.app.preferences.api.MovieBoxPreferences
import com.orhanobut.logger.Logger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivityViewModel(appPreferences: MovieBoxPreferences) : ViewModel() {
    val shouldUseDarkTheme: Flow<Boolean> = appPreferences.shouldUseDarkTheme
}
