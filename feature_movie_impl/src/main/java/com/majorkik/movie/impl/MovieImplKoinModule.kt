package com.majorkik.movie.impl

import com.majorkik.movie.api.repository.MovieRepository
import com.majorkik.movie.impl.repository.MovieRepositoryImpl
import com.majorkik.movie.impl.service.MoviesApiService
import com.majorkik.network.retrofit.createTmdbV3WebService
import org.koin.dsl.module

val movieImplKoinModule = module {
    single { createTmdbV3WebService<MoviesApiService>() }
    factory<MovieRepository> { MovieRepositoryImpl(get()) }
}
