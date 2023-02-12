package com.majorkik.ui.authorization.ui

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

internal class AuthViewModel() : ViewModel(),
    ContainerHost<AuthViewState, AuthSideEffect> {

    override val container: Container<AuthViewState, AuthSideEffect> = container(AuthViewState())
}

internal class AuthViewState(
    val isLoading: Boolean = false,
)

internal class AuthSideEffect
