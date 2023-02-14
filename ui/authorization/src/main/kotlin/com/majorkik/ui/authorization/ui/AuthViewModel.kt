package com.majorkik.ui.authorization.ui

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

internal class AuthViewModel : ViewModel(),
    ContainerHost<AuthViewState, AuthSideEffect> {

    override val container: Container<AuthViewState, AuthSideEffect> = container(AuthViewState())

    fun actionUpdateLogin(value: String) = intent { reduce { state.copy(login = value) } }
    fun actionUpdatePassword(value: String) = intent { reduce { state.copy(password = value) } }
}

internal data class AuthViewState(
    val isLoading: Boolean = false,
    val login: String = "",
    val password: String = "",
)

internal class AuthSideEffect
