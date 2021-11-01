package com.majorkik.tmdb.impl.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.majorkik.tmdb.impl.APIConstants
import com.skydoves.sandwich.coroutines.CoroutinesResponseCallAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

internal val okHttpClient = OkHttpClient()

internal fun getLoggingInterceptorBodyLevel() = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

internal fun getInterceptor() = Interceptor.invoke { chain ->
    val url = chain.request()
        .url
        .newBuilder()
        .build()

    val request = chain.request()
        .newBuilder()
        .url(url)
        .build()

    return@invoke chain.proceed(request)
}

internal fun createHttpClient(): OkHttpClient {
    return okHttpClient.newBuilder()
        .addInterceptor(getLoggingInterceptorBodyLevel())
        .addNetworkInterceptor(getInterceptor())
        .build()
}

internal fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val mediaType = "application/json".toMediaType()
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(APIConstants.baseUrl)
        .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory.create())
        .addConverterFactory(Json.asConverterFactory(mediaType))
        .build()
}

internal fun createApiService(): ApiService {
    return createRetrofit(createHttpClient()).create(ApiService::class.java)
}
