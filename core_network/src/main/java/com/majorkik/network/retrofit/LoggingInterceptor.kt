package com.majorkik.network.retrofit

import okhttp3.logging.HttpLoggingInterceptor

fun getLoggingInterceptorBodyLevel() = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}
