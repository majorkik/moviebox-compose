package com.majorkik.movie_impl.model.response

import com.majorkik.movie_api.model.Movie
import com.majorkik.movie_api.model.Movies
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class MovieResponse(
    val results: List<Movie>,
    val page: Int,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "total_results") val totalResults: Int
) {
    @JsonClass(generateAdapter = true)
    internal data class Movie(
        val adult: Boolean,
        @Json(name = "backdrop_path") val backdropPath: String?,
        @Json(name = "genre_ids") val genreIds: List<Int>,
        val id: Int,
        @Json(name = "original_language") val originalLanguage: String,
        @Json(name = "original_title") val originalTitle: String,
        val overview: String,
        val popularity: Double,
        @Json(name = "poster_path") val posterPath: String?,
        @Json(name = "release_date") val releaseDate: String,
        val title: String,
        val video: Boolean,
        @Json(name = "vote_average") val voteAverage: Double,
        @Json(name = "vote_count") val voteCount: Int
    )
}

internal fun MovieResponse.toDomainModel() = Movies(
    results = results.map { it.toDomainModel() },
    page = page,
    totalPages = totalPages,
    totalResults = totalResults
)

internal fun MovieResponse.Movie.toDomainModel() = Movie(
    adult = adult,
    backdropPath = backdropPath,
    genreIds = genreIds,
    id = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)
