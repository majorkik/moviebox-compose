package com.majorkik.tmdb.api.usecase

import com.majorkik.tmdb.api.repository.MovieDetailsRepository

class GetMovieDetailsUseCase(private val repository: MovieDetailsRepository) {
    suspend operator fun invoke(movieId: Int) = repository.getMovieDetailsById(id = movieId)
}
