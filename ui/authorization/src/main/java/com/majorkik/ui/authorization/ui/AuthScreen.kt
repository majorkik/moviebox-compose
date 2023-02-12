package com.majorkik.ui.authorization.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.majorkik.core.ui.theme.MBTheme
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.getViewModel

@Destination
@Composable
fun AuthScreen() {
    val viewModel: AuthViewModel = getViewModel()
    val viewState by viewModel.container.stateFlow.collectAsState()

    AuthContent(viewState = viewState)
}

@Composable
internal fun AuthContent(viewState: AuthViewState) {
    Box(modifier = Modifier.fillMaxSize().background(MBTheme.colors.background.base))
}

@Preview
@Composable
private fun AuthContentPreview() {
    AuthContent(viewState = AuthViewState())
}
