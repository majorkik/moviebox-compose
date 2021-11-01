package com.majorkik.tmdb.api.repository

import com.majorkik.tmdb.api.network.NetworkResult
import com.majorkik.tmdb.api.model.MovieDetails

interface MovieDetailsRepository {
    suspend fun fetchMovieDetails(id: Long): NetworkResult<MovieDetails, String>
}
