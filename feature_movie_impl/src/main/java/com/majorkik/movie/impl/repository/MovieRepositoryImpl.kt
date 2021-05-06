package com.majorkik.movie.impl.repository

import com.majorkik.api.model.Movies
import com.majorkik.api.repository.MovieRepository
import com.majorkik.movie.impl.model.response.toDomainModel
import com.majorkik.movie.impl.service.MoviesApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow

internal class MovieRepositoryImpl(private val api: MoviesApiService) : MovieRepository {

    override suspend fun fetchPopularMovies(page: Int?, language: String?, region: String?): Flow<Movies> {
        return flow { emit(api.getPopularMovies(page = page, language = language, region = region)) }
            .flowOn(Dispatchers.IO)
            .map { it.toDomainModel() }
            .flowOn(Dispatchers.Default)
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
