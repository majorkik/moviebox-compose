package com.majorkik.home

import com.majorkik.home.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiHomeModule = module {
    viewModel { HomeViewModel(get()) }
}
