package com.majorkik.tmdb.impl.respone

import com.majorkik.tmdb.api.APIConstants
import com.majorkik.tmdb.api.model.MovieDetails
import com.majorkik.tmdb.api.util.DateUtil
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MovieDetailsResponse(
    @SerialName("adult") val adult: Boolean,
    @SerialName("backdrop_path") val backdropPath: String?,
    @SerialName("belongs_to_collection") val belongsToCollection: BelongsToCollection?,
    @SerialName("budget") val budget: Long,
    @SerialName("genres") val genres: List<Genre>,
    @SerialName("homepage") val homepage: String?,
    @SerialName("id") val id: Long,
    @SerialName("imdb_id") val imdbId: String?,
    @SerialName("original_language") val originalLanguage: String,
    @SerialName("original_title") val originalTitle: String,
    @SerialName("overview") val overview: String?,
    @SerialName("popularity") val popularity: Double,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("production_companies") val productionCompanies: List<ProductionCompany>,
    @SerialName("production_countries") val productionCountries: List<ProductionCountry>,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("revenue") val revenue: Long,
    @SerialName("runtime") val runtime: Int?,
    @SerialName("spoken_languages") val spokenLanguages: List<SpokenLanguage>,
    @SerialName("status") val status: String,
    @SerialName("tagline") val tagline: String?,
    @SerialName("title") val title: String,
    @SerialName("video") val video: Boolean,
    @SerialName("vote_average") val voteAverage: Double,
    @SerialName("vote_count") val voteCount: Int,
    @SerialName("images") val images: Images
) {
    @Serializable
    data class Genre(
        @SerialName("id") val id: Long,
        @SerialName("name") val name: String
    )

    @Serializable
    data class BelongsToCollection(
        @SerialName("id") val id: Long,
        @SerialName("name") val name: String,
        @SerialName("poster_path") val posterPath: String?,
        @SerialName("backdrop_path") val backdropPath: String?
    )

    @Serializable
    data class ProductionCompany(
        @SerialName("id") val id: Long,
        @SerialName("logo_path") val logoPath: String?,
        @SerialName("name") val name: String,
        @SerialName("origin_country") val originCountry: String
    )

    @Serializable
    data class ProductionCountry(
        @SerialName("iso_3166_1") val iso31661: String,
        @SerialName("name") val name: String
    )

    @Serializable
    data class SpokenLanguage(
        @SerialName("iso_639_1") val iso6391: String,
        @SerialName("name") val name: String
    )

    @Serializable
    data class Images(
        @SerialName("backdrops") val backdrops: List<Image>,
        @SerialName("posters") val posters: List<Image>
    ) {
        @Serializable
        data class Image(
            @SerialName("aspect_ratio") val aspectRatio: Double?,
            @SerialName("file_path") val filePath: String?
        )
    }
}

internal fun MovieDetailsResponse.toDomainModel() = MovieDetails(
    adult = adult,
    backdropPath = backdropPath,
    belongsToCollection = belongsToCollection?.toDomainModel(),
    budget = budget,
    genres = genres.map { it.toDomainModel() },
    homepage = homepage,
    id = id,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    productionCompanies = productionCompanies.map { it.toDomainModel() },
    productionCountries = productionCountries.map { it.toDomainModel() },
    releaseDate = DateUtil.tryParse(date = releaseDate),
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages.map { it.toDomainModel() },
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount,
    posterLinks = images.posters.map { image -> APIConstants.buildImageUrl(path = image.filePath) },
    postersCount = images.posters.count(),
    backdropLinks = images.backdrops.map { image -> APIConstants.buildImageUrl(path = image.filePath) },
    backdropsCount = images.backdrops.count()
)

internal fun MovieDetailsResponse.Genre.toDomainModel() = MovieDetails.Genre(
    id = id,
    name = name
)

internal fun MovieDetailsResponse.BelongsToCollection.toDomainModel() = MovieDetails.BelongsToCollection(
    id = id,
    name = name,
    posterPath = posterPath,
    backdropPath = backdropPath
)

internal fun MovieDetailsResponse.ProductionCompany.toDomainModel() = MovieDetails.ProductionCompany(
    id = id,
    logoPath = logoPath,
    name = name,
    originCountry = originCountry
)

internal fun MovieDetailsResponse.ProductionCountry.toDomainModel() = MovieDetails.ProductionCountry(
    iso = iso31661,
    name = name
)

internal fun MovieDetailsResponse.SpokenLanguage.toDomainModel() = MovieDetails.SpokenLanguage(
    iso = iso6391,
    name = name
)
