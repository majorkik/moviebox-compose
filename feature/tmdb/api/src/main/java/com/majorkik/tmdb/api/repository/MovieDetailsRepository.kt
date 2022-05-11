package com.majorkik.tmdb.api.repository

import com.majorkik.tmdb.api.model.MovieDetails
import com.majorkik.tmdb.api.network.NetworkResult

interface MovieDetailsRepository {
    suspend fun fetchMovieDetails(id: Int): NetworkResult<MovieDetails, String>
}
