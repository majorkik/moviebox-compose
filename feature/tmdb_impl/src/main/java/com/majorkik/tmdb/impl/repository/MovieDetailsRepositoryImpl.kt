package com.majorkik.tmdb.impl.repository

import com.majorkik.tmdb.api.network.NetworkResult
import com.majorkik.tmdb.api.model.MovieDetails
import com.majorkik.tmdb.api.repository.MovieDetailsRepository
import com.majorkik.tmdb.impl.network.ApiService
import com.majorkik.tmdb.impl.network.safeRequest
import com.majorkik.tmdb.impl.respone.toDomainModel

internal class MovieDetailsRepositoryImpl(private val api: ApiService) : MovieDetailsRepository {
    override suspend fun fetchMovieDetails(id: Long): NetworkResult<MovieDetails, String> {
        return api.getMovieById(id = id).safeRequest(
            onSuccess = { it?.toDomainModel() },
            onError = { "Error" }
        )
    }
}
