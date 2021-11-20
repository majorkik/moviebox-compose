package com.majorkik.tmdb.api.model

import com.soywiz.klock.Date

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
    val releaseDate: Date?,
    val revenue: Long,
    val runtime: Int?,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String?,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    val posterLinks: List<String>,
    val postersCount: Int,
    val backdropLinks: List<String>,
    val backdropsCount: Int,
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

    companion object {
        fun mock() = MovieDetails(
            adult = false,
            backdropPath = null,
            belongsToCollection = null,
            budget = 0,
            genres = listOf(),
            homepage = null,
            id = 0,
            imdbId = null,
            originalLanguage = "",
            originalTitle = "",
            overview = null,
            popularity = 0.0,
            posterPath = null,
            productionCompanies = listOf(),
            productionCountries = listOf(),
            releaseDate = null,
            revenue = 0,
            runtime = null,
            spokenLanguages = listOf(),
            status = "",
            tagline = null,
            title = "",
            video = false,
            voteAverage = 0.0,
            voteCount = 0,
            posterLinks = listOf(),
            postersCount = 0,
            backdropLinks = listOf(),
            backdropsCount = 0
        )
    }
}
