package com.majorkik.tmdb.impl.repository

import com.majorkik.tmdb.api.model.MovieDetails
import com.majorkik.tmdb.api.repository.MovieDetailsRepository

internal class MovieDetailsRepositoryImpl : MovieDetailsRepository {
    override suspend fun fetchMovieDetails(id: Long): MovieDetails {
        return MovieDetails(
            adult = true,
            backdropPath = "",
            belongsToCollection = "",
            budget = 1_000_000,
            genres = emptyList(),
            homepage = "",
            id = 1,
            imdbId = "1",
            originalLanguage = "",
            originalTitle = "",
            overview = "",
            popularity = 9.1,
            posterPath = "",
            productionCompanies = emptyList(),
            productionCountries = emptyList(),
            releaseDate = null,
            revenue = null,
            runtime = null,
            spokenLanguages = emptyList(),
            status = "",
            tagline = "",
            title = "",
            video = null,
            voteAverage = 2.32,
            voteCount = 213
        )
    }
}
