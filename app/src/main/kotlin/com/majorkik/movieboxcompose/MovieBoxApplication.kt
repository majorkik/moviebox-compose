package com.majorkik.movieboxcompose

import android.app.Application
import com.majorkik.movie.details.movieDetailsModule
import com.majorkik.tmdb.impl.tmdbImplModule
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class MovieBoxApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Logger.addLogAdapter(AndroidLogAdapter())
        Timber.plant(object : Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                Logger.log(priority, tag, message, t)
            }
        })

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MovieBoxApplication)
            modules(appModule, tmdbImplModule, movieDetailsModule)
        }
    }
}
