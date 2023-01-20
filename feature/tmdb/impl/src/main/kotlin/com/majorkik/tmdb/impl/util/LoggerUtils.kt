package com.majorkik.tmdb.impl.util

import com.majorkik.tmdb.impl.logger
import com.slack.eithernet.ApiResult

fun <T : Any> ApiResult.Failure<T>.printLog() {
    when (this) {
        is ApiResult.Failure.NetworkFailure -> logger.error(this.error.localizedMessage)
        is ApiResult.Failure.UnknownFailure -> logger.error(this.error.localizedMessage)
        is ApiResult.Failure.HttpFailure -> {
            logger.error { "HttpFailure: ${this.error?.toString()}, code: ${this.code}" }
        }
        is ApiResult.Failure.ApiFailure -> logger.error { "ApiFailure: ${this.error?.toString()}" }
    }
}
