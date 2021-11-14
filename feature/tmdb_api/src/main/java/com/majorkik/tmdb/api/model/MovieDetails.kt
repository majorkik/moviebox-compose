package com.majorkik.tmdb.api.model

import com.majorkik.tmdb.api.APIConstants

data class MovieDetails(
    val adult: Boolean,
    val backdropPath: String?,
    val belongsToCollection: BelongsToCollection?,
    val budget: Long,
    val genres: List<Genre>,
    val homepage: String?,
    val id: Long,
    val imdbId: String?,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String?,
    val popularity: Double,
    val posterPath: String?,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountry>,
    val releaseDate: String,
    val revenue: Long,
    val runtime: Int?,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String?,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    val images: Images
) {
    data class Genre(
        val id: Long,
        val name: String
    )

    data class BelongsToCollection(
        val id: Long,
        val name: String,
        val posterPath: String?,
        val backdropPath: String?
    )

    data class ProductionCompany(
        val id: Long,
        val logoPath: String?,
        val name: String,
        val originCountry: String
    )

    data class ProductionCountry(
        val iso: String,
        val name: String
    )

    data class SpokenLanguage(
        val iso: String,
        val name: String
    )

    data class Images(
        val backdrops: List<Image>,
        val posters: List<Image>
    ) {
        data class Image(
            val aspectRatio: Double,
            val filePath: String,
        ) {
            val fullUrl: String
                get() = "${APIConstants.buildImageUrl()}$filePath"
        }
    }
}
