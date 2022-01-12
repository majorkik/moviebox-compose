package com.majorkik.tmdb.impl.respone

import com.majorkik.tmdb.api.model.Genre
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GenresResponse(
    @SerialName("genres") val genres: List<GenreResponse>
) {
    @Serializable
    data class GenreResponse(@SerialName("id") val id: Int, @SerialName("name") val name: String)
}

internal fun GenresResponse.toDomainModel(): List<Genre> {
    return genres.map { it.toDomainModel() }
}

internal fun GenresResponse.GenreResponse.toDomainModel(): Genre = Genre(id = id, name = name)
