package com.majorkik.api.repository

import com.majorkik.api.model.Movies
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun fetchPopularMovies(page: Int?, language: String?, region: String?): Flow<Movies>

    suspend fun fetchTopRatedMovies(page: Int?, language: String?, region: String?): Flow<Movies>

    suspend fun fetchUpcomingMovies(page: Int?, language: String?, region: String?): Flow<Movies>

    suspend fun fetchNowPlayingMovies(page: Int?, language: String?, region: String?): Flow<Movies>

    suspend fun fetchTrendingMovies(page: Int?, mediaType: String, timeWindow: String, language: String?): Flow<Movies>
}
