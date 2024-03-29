package com.majorkik.movieboxcompose

import android.app.Application
import com.majorkik.app.preferences.impl.appPreferencesImplModule
import com.majorkik.tmdb.api.tmdbApiModule
import com.majorkik.tmdb.impl.tmdbImplModule
import com.majorkik.ui.details.movieDetailsModule
import com.majorkik.ui.nav.home.uiNavHome
import com.majorkik.ui.nav.profile.uiNavProfile
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class MovieBoxApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MovieBoxApplication)
            modules(
                appModule,
                tmdbApiModule,
                tmdbImplModule,
                movieDetailsModule,
                appPreferencesImplModule,
                uiNavProfile,
                uiNavHome
            )
        }
    }
}
