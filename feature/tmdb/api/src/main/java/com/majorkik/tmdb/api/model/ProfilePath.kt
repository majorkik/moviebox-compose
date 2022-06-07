package com.majorkik.tmdb.api.model

import com.majorkik.tmdb.api.UrlConstants

@JvmInline
value class ProfilePath(val value: String) {
    @Suppress("unused")
    enum class Size(val path: String) {
        Width("w45"),
        Width185("w185"),
        Width300("w300"),
        Original("original"),
    }

    fun build(size: Size = Size.Original): String {
        return UrlConstants.IMAGE_URL + size.path + value
    }
}

fun String.toProfilePath() = ProfilePath(value = this)
