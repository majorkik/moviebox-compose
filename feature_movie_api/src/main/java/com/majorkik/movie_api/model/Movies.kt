package com.majorkik.movie_api.model

data class Movies(
    val results: List<Movie>,
    val page: Int,
    val totalPages: Int,
    val totalResults: Int
)
