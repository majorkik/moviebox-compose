package com.majorkik.api.usecase

import com.majorkik.api.model.Movie
import com.majorkik.api.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetMoviesUseCase(private val repository: MovieRepository) {

    sealed class Result {
        data class Success(val list: List<Movie>, val page: Int, val totalPages: Int) : Result()
        data class Error(val message: String?, val code: Int?) : Result()
    }

    suspend fun getPopularMovies(page: Int?, language: String?, region: String?): Flow<Result> {
        return repository.fetchPopularMovies(page = page, language = language, region = region)
            .map { Result.Success(list = it.results, page = it.page, totalPages = it.totalPages) }
    }

    suspend fun getTopRatedMovies(page: Int?, language: String?, region: String?): Flow<Result> {
        return repository.fetchTopRatedMovies(page = page, language = language, region = region)
            .map { Result.Success(list = it.results, page = it.page, totalPages = it.totalPages) }
    }

    suspend fun getUpcomingMovies(page: Int?, language: String?, region: String?): Flow<Result> {
        return repository.fetchUpcomingMovies(page = page, language = language, region = region)
            .map { Result.Success(list = it.results, page = it.page, totalPages = it.totalPages) }
    }

    suspend fun getNowPlayingMovies(page: Int?, language: String?, region: String?): Flow<Result> {
        return repository.fetchNowPlayingMovies(page = page, language = language, region = region)
            .map { Result.Success(list = it.results, page = it.page, totalPages = it.totalPages) }
    }
}
