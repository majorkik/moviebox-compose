package com.majorkik.tmdb.impl.repository

import com.majorkik.tmdb.api.model.PagedMovieResult
import com.majorkik.tmdb.api.network.NetworkResult
import com.majorkik.tmdb.api.repository.MoviesRepository
import com.majorkik.tmdb.impl.network.ApiService
import com.majorkik.tmdb.impl.network.safeRequest
import com.majorkik.tmdb.impl.network.suspendString
import com.majorkik.tmdb.impl.respone.toDomainModel

internal class MoviesRepositoryImpl(private val api: ApiService) : MoviesRepository {
    override suspend fun getPopularMovies(page: Int): NetworkResult<PagedMovieResult, String?> {
        return safeRequest(
            call = { api.getPopularMovies(page = page) },
            onSuccess = { it?.toDomainModel() },
            onError = { it?.suspendString() }
        )
    }
}
