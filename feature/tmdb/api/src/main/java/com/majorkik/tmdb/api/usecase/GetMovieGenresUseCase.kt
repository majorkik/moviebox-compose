package com.majorkik.tmdb.api.usecase

import com.majorkik.tmdb.api.repository.GenresRepository

class GetMovieGenresUseCase(private val repository: GenresRepository) {
    suspend operator fun invoke() = repository.getMovieGenres()
}
