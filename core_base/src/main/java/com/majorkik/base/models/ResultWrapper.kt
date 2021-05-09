package com.majorkik.base.models

sealed class ResultWrapper<out T> {
    data class Success<out T>(val result: T) : ResultWrapper<T>()

    data class GenericError(val code: Int?, val message: String?) : ResultWrapper<Nothing>()

    object NetworkError : ResultWrapper<Nothing>()
}

fun <T> T.toResultSuccess() = ResultWrapper.Success(result = this)
