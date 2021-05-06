package com.majorkik.movie_impl.service

import com.majorkik.movie_impl.model.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface MoviesApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int?,
        @Query("language") language: String?,
        @Query("region") region: String?
    ): MovieResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page: Int?,
        @Query("language") language: String?,
        @Query("region") region: String?
    ): MovieResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int?,
        @Query("language") language: String?,
        @Query("region") region: String?
    ): MovieResponse

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int?,
        @Query("language") language: String?,
        @Query("region") region: String?
    ): MovieResponse

    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingMovies(
        @Query("page") page: Int?,
        @Query("language") language: String?,
        @Path("media_type") mediaType: String,
        @Path("time_window") timeWindow: String
    ): MovieResponse
}
