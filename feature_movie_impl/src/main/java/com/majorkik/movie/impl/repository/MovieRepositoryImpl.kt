package com.majorkik.movie.impl.repository

import com.majorkik.base.models.ResultWrapper
import com.majorkik.base.models.toResultSuccess
import com.majorkik.movie.api.model.Movies
import com.majorkik.movie.api.repository.MovieRepository
import com.majorkik.movie.impl.model.response.toDomainModel
import com.majorkik.movie.impl.service.MoviesApiService
import com.majorkik.network.data.models.toErrorResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import java.io.IOException

internal class MovieRepositoryImpl(private val api: MoviesApiService) : MovieRepository {

    override suspend fun fetchPopularMovies(
        page: Int?,
        language: String?,
        region: String?
    ): Flow<ResultWrapper<Movies>> {
        return flow { emit(api.getPopularMovies(page = page, language = language, region = region)) }
            .flowOn(Dispatchers.IO)
            .map {
                it.toDomainModel().toResultSuccess()
            }
            .catch {
                when (it) {
                    is HttpException -> {
                        val response = it.toErrorResponse()

                        ResultWrapper.GenericError(code = response?.statusCode, message = response?.statusMessage)
                    }
                    is IOException -> ResultWrapper.NetworkError
                    else -> ResultWrapper.GenericError(null, null)
                }
            }.flowOn(Dispatchers.Default)
    }

    override suspend fun fetchTopRatedMovies(page: Int?, language: String?, region: String?): Flow<Movies> {
        return flow { emit(api.getTopRatedMovies(page = page, language = language, region = region)) }
            .flowOn(Dispatchers.IO)
            .map { it.toDomainModel() }
            .flowOn(Dispatchers.Default)
    }

    override suspend fun fetchUpcomingMovies(page: Int?, language: String?, region: String?): Flow<Movies> {
        return flow { emit(api.getUpcomingMovies(page = page, language = language, region = region)) }
            .flowOn(Dispatchers.IO)
            .map { it.toDomainModel() }
            .flowOn(Dispatchers.Default)
    }

    override suspend fun fetchNowPlayingMovies(page: Int?, language: String?, region: String?): Flow<Movies> {
        return flow { emit(api.getNowPlayingMovies(page = page, language = language, region = region)) }
            .flowOn(Dispatchers.IO)
            .map { it.toDomainModel() }
            .flowOn(Dispatchers.Default)
    }

    override suspend fun fetchTrendingMovies(
        page: Int?,
        mediaType: String,
        timeWindow: String,
        language: String?
    ): Flow<Movies> {
        return flow {
            emit(
                api.getTrendingMovies(
                    page = page,
                    language = language,
                    timeWindow = timeWindow,
                    mediaType = mediaType
                )
            )
        }
            .flowOn(Dispatchers.IO)
            .map { it.toDomainModel() }
            .flowOn(Dispatchers.Default)
    }
}
