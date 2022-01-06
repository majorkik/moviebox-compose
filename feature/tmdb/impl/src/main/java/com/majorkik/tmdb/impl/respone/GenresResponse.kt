package com.majorkik.tmdb.impl.respone

import com.majorkik.tmdb.api.model.Genre
import kotlinx.serialization.Serializable

@Serializable
internal data class GenresResponse(
    val genres: List<GenreResponse>
) {
    @Serializable
    data class GenreResponse(val id: Int, val name: String)
}

internal fun GenresResponse.toDomainModel(): List<Genre> {
    return genres.map { it.toDomainModel() }
}

internal fun GenresResponse.GenreResponse.toDomainModel(): Genre = Genre(id = id, name = name)
