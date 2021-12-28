package com.majorkik.movieboxcompose

import com.majorkik.movieboxcompose.ui.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainActivityViewModel(get()) }
}
