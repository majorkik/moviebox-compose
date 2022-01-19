package com.majorkik.tmdb.impl.respone

import com.majorkik.tmdb.api.model.Movie
import com.majorkik.tmdb.api.model.PagedMovieResult
import com.majorkik.tmdb.impl.tryParseToDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MoviesPagedResponse(
    @SerialName("page") val page: Int,
    @SerialName("results") val data: List<Movie>,
    @SerialName("total_pages") val totalPages: Int,
    @SerialName("total_results") val totalResults: Int
) {
    @Serializable
    internal data class Movie(
        @SerialName("id") val id: Int,
        @SerialName("adult") val adult: Boolean,
        @SerialName("backdrop_path") val backdropPath: String?,
        @SerialName("genre_ids") val genreIds: List<Int>,
        @SerialName("original_language") val originalLanguage: String,
        @SerialName("original_title") val originalTitle: String,
        @SerialName("overview") val overview: String,
        @SerialName("popularity") val popularity: Double,
        @SerialName("poster_path") val posterPath: String?,
        @SerialName("release_date") val releaseDate: String,
        @SerialName("title") val title: String,
        @SerialName("video") val video: Boolean,
        @SerialName("vote_average") val voteAverage: Double,
        @SerialName("vote_count") val voteCount: Int
    )
}

internal fun MoviesPagedResponse.toDomainModel() = PagedMovieResult(
    data = data.map { it.toDomainModel() },
    page = page,
    totalPages = totalPages,
    totalItems = totalResults
)

internal fun MoviesPagedResponse.Movie.toDomainModel() = Movie(
    id = id,
    title = title,
    overview = overview,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = tryParseToDate(date = releaseDate),
    video = video,
    backdropPath = backdropPath,
    voteAverage = voteAverage,
    voteCount = voteCount,
    genreIds = genreIds,
    adult = adult
)
