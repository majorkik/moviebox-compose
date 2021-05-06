package com.majorkik.network.data.models

import com.majorkik.network.network.models.BaseErrorResponseJsonAdapter
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import retrofit2.HttpException

@JsonClass(generateAdapter = true)
data class BaseErrorResponse(
    @Json(name = "status_code")
    val statusCode: Int?,
    @Json(name = "status_message")
    val statusMessage: String?
)

fun HttpException.toErrorResponse(): BaseErrorResponse {
    return response()?.errorBody()?.source()?.runCatching {
        BaseErrorResponseJsonAdapter(Moshi.Builder().build()).fromJson(this)
    }.getOrNull()
}
