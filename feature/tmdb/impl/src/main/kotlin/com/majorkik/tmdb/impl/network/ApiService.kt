package com.majorkik.tmdb.impl.network

import com.majorkik.tmdb.impl.response.GenresResponse
import com.majorkik.tmdb.impl.response.MovieDetailsResponse
import com.majorkik.tmdb.impl.response.PagedMoviesResponse
import com.majorkik.tmdb.impl.response.PagedTVsResponse
import com.slack.eithernet.ApiResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface ApiService {
    /** Movie */
    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") id: Int,
        @Query("append_to_response") appendToResponse: String?,
        @Query("language") language: String = "en"
    ): ApiResult<MovieDetailsResponse, Unit>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int,
        @Query("language") language: String = "en",
        @Query("region") region: String? = null
    ): Response<PagedMoviesResponse>

    @GET("trending/movie/week")
    suspend fun getTrendingMovies(@Query("page") page: Int): Response<PagedMoviesResponse>

    /** TVs */
    @GET("tv/popular")
    suspend fun getPopularTVs(
        @Query("page") page: Int,
        @Query("language") language: String = "en"
    ): Response<PagedTVsResponse>

    @GET("trending/tv/week")
    suspend fun getTrendingTVs(@Query("page") page: Int): Response<PagedTVsResponse>

    /** Genres */
    @GET("genre/movie/list")
    suspend fun getMovieGenres(): Response<GenresResponse>

    @GET("genre/tv/list")
    suspend fun getTVGenres(): Response<GenresResponse>
}
