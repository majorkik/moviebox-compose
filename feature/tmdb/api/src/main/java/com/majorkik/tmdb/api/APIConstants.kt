package com.majorkik.tmdb.api

object APIConstants {
    const val baseUrl = "https://api.themoviedb.org/3/"
    private const val imageUrl = "https://image.tmdb.org/t/p/"

    enum class ImageSize(val path: String) {
        Original("original")
    }

    fun buildImageUrl(path: String?, imageSize: ImageSize = ImageSize.Original): String {
        return imageUrl + imageSize.path + (path ?: "")
    }
}
