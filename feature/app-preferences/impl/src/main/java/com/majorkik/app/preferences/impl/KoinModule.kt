package com.majorkik.app.preferences.impl

import com.majorkik.app.preferences.api.MovieBoxPreferences
import com.majorkik.app.preferences.api.dataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appPreferencesImplModule = module {
    single<MovieBoxPreferences> { MovieBoxPreferencesImpl(dataStore = androidContext().dataStore) }
}
