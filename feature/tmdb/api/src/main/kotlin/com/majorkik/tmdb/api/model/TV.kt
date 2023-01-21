package com.majorkik.tmdb.api.model

import com.soywiz.klock.Date

data class TV(
    val adult: Boolean,
    val backdropPath: BackdropPath?,
    val genreIds: List<Int>,
    val id: Int,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: PosterPath?,
    val releaseDate: Date?,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)
