package com.majorkik.movieboxcompose.ui

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.majorkik.home.ui.HomeScreen

@Composable
fun MainContainer() {
    Scaffold(backgroundColor = Color.White) {
        HomeScreen()
    }
}
