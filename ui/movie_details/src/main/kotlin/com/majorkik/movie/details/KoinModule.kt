package com.majorkik.movie.details

import com.majorkik.movie.details.ui.MovieDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieDetailsModule = module {
    viewModel { MovieDetailsViewModel(get()) }
}
