package com.majorkik.movie.api.repository

import com.majorkik.base.models.ResultWrapper
import com.majorkik.movie.api.model.Movies
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun fetchPopularMovies(page: Int?, language: String?, region: String?): Flow<ResultWrapper<Movies>>

    suspend fun fetchTopRatedMovies(page: Int?, language: String?, region: String?): Flow<Movies>

    suspend fun fetchUpcomingMovies(page: Int?, language: String?, region: String?): Flow<Movies>

    suspend fun fetchNowPlayingMovies(page: Int?, language: String?, region: String?): Flow<Movies>

    suspend fun fetchTrendingMovies(page: Int?, mediaType: String, timeWindow: String, language: String?): Flow<Movies>
}
