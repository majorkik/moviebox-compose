package com.majorkik.ui.details

import com.majorkik.ui.details.ui.MovieDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieDetailsModule = module {
    viewModel { MovieDetailsViewModel(handle = get(), getMovieDetailsByIdUseCase = get()) }
}
