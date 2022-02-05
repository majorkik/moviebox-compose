package com.majorkik.tmdb.api.model

data class PagedTVsResult(
    val movies: List<TV>,
    val page: Int,
    val totalPages: Int,
    val totalItems: Int
)
