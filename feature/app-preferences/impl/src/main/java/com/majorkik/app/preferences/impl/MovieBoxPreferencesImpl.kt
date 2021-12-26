package com.majorkik.app.preferences.impl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.majorkik.app.preferences.api.MovieBoxPreferences
import com.orhanobut.logger.Logger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class MovieBoxPreferencesImpl(private val dataStore: DataStore<Preferences>) : MovieBoxPreferences {
    override val shouldUseDarkTheme: Flow<Boolean> = dataStore.data
        .catch { exception ->
            Logger.e(exception, "Error inside [darkModeStateFlow]")

            emit(emptyPreferences())
        }
        .map { preferences ->
            preferences[IS_DARK_MODE] ?: isDarkModeByDefault
        }

    override suspend fun setThemeMode(isDark: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_DARK_MODE] = isDark
        }
    }

    override suspend fun isDarkMode(): Boolean? =
        dataStore.data.map { preferences -> preferences[IS_DARK_MODE] ?: isDarkModeByDefault }.firstOrNull()

    companion object {
        private const val isDarkModeByDefault = true

        private val IS_DARK_MODE = booleanPreferencesKey("is_dark_mode_key")
    }
}
