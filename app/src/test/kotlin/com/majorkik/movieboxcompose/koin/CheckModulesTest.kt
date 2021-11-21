package com.majorkik.movieboxcompose.koin

import com.majorkik.movie.details.movieDetailsModule
import com.majorkik.movieboxcompose.appModule
import com.majorkik.tmdb.impl.tmdbApiModule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

class CheckModulesTest : KoinTest {
    @Test
    fun verifyKoinApp() {
        checkModules {
            modules(appModule, tmdbApiModule, movieDetailsModule)
        }
    }
}
