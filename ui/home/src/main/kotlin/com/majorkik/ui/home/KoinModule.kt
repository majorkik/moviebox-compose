package com.majorkik.ui

import com.majorkik.ui.home.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiHomeModule = module {
    viewModel { HomeViewModel(get()) }
}
