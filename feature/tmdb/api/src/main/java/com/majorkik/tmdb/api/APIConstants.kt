package com.majorkik.tmdb.api

object APIConstants {
    const val baseUrl = "https://api.themoviedb.org/3/"
    private const val imageUrl = "https://image.tmdb.org/t/p/"

    enum class ImageSize(val path: String) {
        Original("original")
    }

    fun buildImageUrl(imageSize: ImageSize = ImageSize.Original) = imageUrl + imageSize.path
}
