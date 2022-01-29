package com.majorkik.tmdb.impl.network

import com.majorkik.tmdb.impl.respone.GenresResponse
import com.majorkik.tmdb.impl.respone.MovieDetailsResponse
import com.majorkik.tmdb.impl.respone.PagedMoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface ApiService {
    /**
     * Movie
     */

    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") id: Long,
        @Query("append_to_response") appendToResponse: String?,
        @Query("language") language: String = "en"
    ): Response<MovieDetailsResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int,
        @Query("language") language: String = "en",
        @Query("region") region: String? = null
    ): Response<PagedMoviesResponse>

    /**
     * Genres
     */

    @GET("genre/movie/list")
    suspend fun getMovieGenres(): Response<GenresResponse>

    @GET("genre/tv/list")
    suspend fun getTVGenres(): Response<GenresResponse>
}
