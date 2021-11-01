package com.majorkik.tmdb.impl

import com.majorkik.tmdb.api.repository.MovieDetailsRepository
import com.majorkik.tmdb.impl.network.createApiService
import com.majorkik.tmdb.impl.repository.MovieDetailsRepositoryImpl
import org.koin.dsl.module

val tmdbApiModule = module {
    // API service
    single { createApiService() }

    // Repositories
    single<MovieDetailsRepository> { MovieDetailsRepositoryImpl(get()) }
}
