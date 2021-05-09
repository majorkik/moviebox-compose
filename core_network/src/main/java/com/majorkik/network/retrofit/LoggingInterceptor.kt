package com.majorkik.network.retrofit

import com.majorkik.network.BuildConfig
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun getLoggingInterceptorBodyLevel() = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

/**
 * Tmdb V3
 */
private val getTmdbV3RequestInterceptor = Interceptor.invoke { chain ->
    val url = chain.request()
        .url
        .newBuilder()
        .addQueryParameter("api_key", BuildConfig.GRADLE_KEY_TMDB)
        .build()

    val request = chain.request()
        .newBuilder()
        .url(url)
        .build()

    return@invoke chain.proceed(request)
}

fun createTmdbV3OkHttpClient(): OkHttpClient {
    return OkHttpClient()
        .newBuilder()
        .addNetworkInterceptor(getTmdbV3RequestInterceptor)
        .addInterceptor(getLoggingInterceptorBodyLevel())
        .build()
}

fun getMoshiInstance(): Moshi = Moshi.Builder().build()

fun getTmdbV3Retrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .client(okHttpClient)
    .baseUrl("https://api.themoviedb.org/3/")
    .addConverterFactory(MoshiConverterFactory.create(getMoshiInstance()))
    .build()

inline fun <reified T> createTmdbV3WebService(): T =
    getTmdbV3Retrofit(createTmdbV3OkHttpClient())
        .create(T::class.java)
