package com.majorkik.tmdb.api

import com.majorkik.tmdb.api.usecase.GetMovieDetailsUseCase
import org.koin.dsl.module

val tmdbApiModule = module {
    factory { GetMovieDetailsUseCase(repository = get()) }
}
