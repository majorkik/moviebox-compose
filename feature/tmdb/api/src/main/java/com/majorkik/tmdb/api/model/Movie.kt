package com.majorkik.tmdb.api.model

import com.soywiz.klock.Date

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val releaseDate: Date?,
    val posterPath: String?,
    val backdropPath: String?,
    val originalLanguage: String,
    val originalTitle: String,
    val popularity: Double,
    val voteAverage: Double,
    val voteCount: Int,
    val genreIds: List<Int>,
    val adult: Boolean,
    val video: Boolean
)
