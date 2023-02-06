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
    val posters: List<PosterPath>,
    val backdrops: List<BackdropPath>,
    val casts: List<Cast>,
    val crews: List<Crew>
) {
    data class Genre(val id: Long, val name: String)

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

    data class ProductionCountry(val iso: String, val name: String)

    data class SpokenLanguage(val iso: String, val name: String)

    data class Cast(
        val castId: Int,
        val character: String,
        val creditId: String,
        val id: Int,
        val knownForDepartment: String,
        val name: String,
        val order: Int,
        val originalName: String,
        val popularity: Double,
        val profilePath: ProfilePath?
    )

    data class Crew(
        val creditId: String,
        val department: String,
        val id: Int,
        val job: String,
        val knownForDepartment: String,
        val name: String,
        val originalName: String,
        val popularity: Double,
        val profilePath: ProfilePath?
    )
}

@Suppress("Detekt.LongMethod", "Detekt.MagicNumber")
fun movieDetailsPreview() = MovieDetails(
    adult = false,
    backdropPath = "/dlrWhn0G3AtxYUx2D9P2bmzcsvF.jpg",
    belongsToCollection = MovieDetails.BelongsToCollection(
        id = 1071588,
        name = "M3GAN Collection",
        posterPath = "/fS57wFKda3h5dtWS3sc9JffE05R.jpg",
        backdropPath = "/uXEJwb8y67vFLaJb4wvHbSH6PjT.jpg"
    ),
    budget = 12000000,
    genres = listOf(
        MovieDetails.Genre(878, "Science Fiction"),
        MovieDetails.Genre(27, "Horror"),
        MovieDetails.Genre(35, "Comedy")
    ),
    homepage = "https://www.m3ganmovie.com",
    id = 536554,
    imdbId = "tt8760708",
    originalLanguage = "en",
    originalTitle = "M3GAN",
    overview = "A brilliant toy company roboticist uses artificial intelligence to develop " +
        "M3GAN, a life-like doll programmed to emotionally bond with her newly orphaned " +
        "niece. But when the doll's programming works too well, she becomes overprotective" +
        " of her new friend with terrifying results.",
    popularity = 5792.786,
    posterPath = "/d9nBoowhjiiYc4FBNtQkPY7c11H.jpg",
    productionCompanies = listOf(
        MovieDetails.ProductionCompany(
            id = 33,
            logoPath = "/8lvHyhjr8oUKOOy2dKXoALWKdp0.png",
            name = "Universal Pictures",
            originCountry = "US"
        )
    ),
    productionCountries = listOf(
        MovieDetails.ProductionCountry(iso = "US", name = "United States of America")
    ),
    releaseDate = Date.invoke(year = 2022, month = 12, day = 28),
    revenue = 125398010,
    runtime = 102,
    spokenLanguages = listOf(MovieDetails.SpokenLanguage(iso = "English", name = "English")),
    status = "Released",
    tagline = "Friendship has evolved.",
    title = "M3GAN",
    video = false,
    voteAverage = 7.542,
    voteCount = 864,
    posters = listOf(
        "/d9nBoowhjiiYc4FBNtQkPY7c11H.jpg".toPosterPath(),
        "/rxDPzExeovcBZY2IVWdYs87AzVE.jpg".toPosterPath(),
        "/jTKHoMmaKHv6IlpKDcouusMZ48Z.jpg".toPosterPath()
    ),
    backdrops = listOf(
        "/q2fY4kMXKoGv4CQf310MCxpXlRI.jpg".toBackdropPath(),
        "/cEtnRjAdTXSITr33hhXSIPIIi3I.jpg".toBackdropPath(),
        "/otOtC45BDzFW7nuxnWHMmnYsicK.jpg".toBackdropPath()
    ),
    casts = listOf(
        MovieDetails.Cast(
            castId = 7,
            character = "Gemma",
            creditId = "5f7e0fd20499f2003a623447",
            id = 1255540,
            knownForDepartment = "Acting",
            name = "Allison Williams",
            order = 7,
            originalName = "Allison Williams",
            popularity = 39.644,
            profilePath = "/yBolxMiZL1EjmNogPzTAuT85qad.jpg".toProfilePath()
        )
    ),
    crews = listOf(
        MovieDetails.Crew(
            creditId = "63462598b3e627008281db60",
            department = "Production",
            id = 494,
            job = "Casting",
            knownForDepartment = "Production",
            name = "Terri Taylor",
            originalName = "Terri Taylor",
            popularity = 3.926,
            profilePath = null
        )
    )
)
