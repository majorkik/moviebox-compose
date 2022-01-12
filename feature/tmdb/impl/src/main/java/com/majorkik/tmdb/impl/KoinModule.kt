package com.majorkik.tmdb.impl

import com.majorkik.tmdb.api.repository.GenresRepository
import com.majorkik.tmdb.api.repository.MovieDetailsRepository
import com.majorkik.tmdb.impl.network.createApiService
import com.majorkik.tmdb.impl.repository.GenresRepositoryImpl
import com.majorkik.tmdb.impl.repository.MovieDetailsRepositoryImpl
import org.koin.dsl.module

val tmdbImplModule = module {
    // API service
    single { createApiService() }

    // Repositories
    single<MovieDetailsRepository> { MovieDetailsRepositoryImpl(api = get()) }
    single<GenresRepository> { GenresRepositoryImpl(api = get()) }
}
