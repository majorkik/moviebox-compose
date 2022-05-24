package com.majorkik.tmdb.api.repository

import arrow.core.Either
import com.majorkik.tmdb.api.model.MovieDetails
import com.majorkik.tmdb.api.network.NetworkResult

interface MovieDetailsRepository {
    suspend fun fetchMovieDetails(id: Int): NetworkResult<MovieDetails, String>
    suspend fun getMovieDetailsById(id: Int): Either<MovieDetailsError, MovieDetails>
}

sealed class MovieDetailsError {
    object NetworkFailure : MovieDetailsError()
    object HttpFailure : MovieDetailsError()
    object ApiFailure : MovieDetailsError()
    object Unknown : MovieDetailsError()
}
