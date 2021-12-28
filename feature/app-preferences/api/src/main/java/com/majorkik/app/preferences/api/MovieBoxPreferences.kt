package com.majorkik.app.preferences.api

import kotlinx.coroutines.flow.Flow

interface MovieBoxPreferences {
    val shouldUseDarkTheme: Flow<Boolean>

    suspend fun setThemeMode(isDark: Boolean)
}
