package com.majorkik.tmdb.impl.respone

import com.majorkik.tmdb.api.model.PagedTVsResult
import com.majorkik.tmdb.api.model.TV
import com.majorkik.tmdb.impl.tryParseToDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PagedTVsResponse(
    @SerialName("page") val page: Int,
    @SerialName("results") val data: List<TV>,
    @SerialName("total_pages") val totalPages: Int,
    @SerialName("total_results") val totalResults: Int
) {
    @Serializable
    data class TV(
        @SerialName("adult") val adult: Boolean,
        @SerialName("backdrop_path") val backdropPath: String?,
        @SerialName("first_air_date") val firstAirDate: String,
        @SerialName("genre_ids") val genreIds: List<Int>,
        @SerialName("id") val id: Int,
        @SerialName("name") val name: String,
        @SerialName("origin_country") val originCountry: List<String>,
        @SerialName("original_language") val originalLanguage: String,
        @SerialName("original_name") val originalName: String?,
        @SerialName("original_title") val originalTitle: String?,
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

internal fun PagedTVsResponse.toDomainModel() = PagedTVsResult(
    movies = data.map { it.toDomainModel() },
    page = page,
    totalPages = totalPages,
    totalItems = totalResults
)

internal fun PagedTVsResponse.TV.toDomainModel() = TV(
    adult = adult,
    backdropPath = backdropPath,
    firstAirDate = tryParseToDate(date = firstAirDate),
    genreIds = genreIds,
    id = id,
    name = name,
    originCountry = originCountry,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle ?: originalName ?: name,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = tryParseToDate(date = releaseDate),
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)
