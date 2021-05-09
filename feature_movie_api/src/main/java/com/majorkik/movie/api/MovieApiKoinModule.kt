package com.majorkik.movie.api

import com.majorkik.movie.api.usecase.GetMoviesUseCase
import org.koin.dsl.module

val movieApiKoinModule = module {
    factory { GetMoviesUseCase(get()) }
}
