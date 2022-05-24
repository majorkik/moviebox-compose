package com.majorkik.tmdb.impl.repository

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.majorkik.tmdb.api.model.MovieDetails
import com.majorkik.tmdb.api.network.NetworkResult
import com.majorkik.tmdb.api.repository.MovieDetailsError
import com.majorkik.tmdb.api.repository.MovieDetailsRepository
import com.majorkik.tmdb.impl.logger
import com.majorkik.tmdb.impl.network.ApiService
import com.majorkik.tmdb.impl.network.safeRequest
import com.majorkik.tmdb.impl.respone.toDomainModel
import com.slack.eithernet.ApiResult
import kotlinx.serialization.SerialName

internal class MovieDetailsRepositoryImpl(private val api: ApiService) : MovieDetailsRepository {
    override suspend fun fetchMovieDetails(id: Int): NetworkResult<MovieDetails, String> {
        return safeRequest(
            call = { api.getMovieById(id = id, appendToResponse = "images") },
            onSuccess = { it?.toDomainModel() },
            onError = { "Error" }
        )
    }

    override suspend fun getMovieDetailsById(id: Int): Either<MovieDetailsError, MovieDetails> {
        return when (val response = api.getMovieById(id = id)) {
            is ApiResult.Success -> {
                logger.error { "$response" }
                response.value.toDomainModel().right()
            }
            is ApiResult.Failure -> {
                logger.error { "$response" }
                when (response) {
                    is ApiResult.Failure.NetworkFailure -> MovieDetailsError.NetworkFailure
                    is ApiResult.Failure.UnknownFailure -> {
                        logger.error { response.error.localizedMessage }

                        MovieDetailsError.Unknown
                    }
                    is ApiResult.Failure.HttpFailure -> MovieDetailsError.HttpFailure
                    is ApiResult.Failure.ApiFailure -> MovieDetailsError.ApiFailure
                }.left()
            }
        }
    }
}

@kotlinx.serialization.Serializable
data class Error(@SerialName("error") val error: String?)
