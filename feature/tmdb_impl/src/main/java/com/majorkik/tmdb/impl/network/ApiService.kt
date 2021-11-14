package com.majorkik.tmdb.impl.network

import com.majorkik.tmdb.impl.respone.MovieDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface ApiService {
    @GET("movie/{movie_id}")
    suspend fun getMovieById(@Path("movie_id") id: Long, @Query("append_to_response") appendToResponse: String?): Response<MovieDetailsResponse>
}
