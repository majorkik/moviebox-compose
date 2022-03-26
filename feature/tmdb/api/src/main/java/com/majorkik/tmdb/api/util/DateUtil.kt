package com.majorkik.tmdb.api.util

import com.majorkik.common.tryParseDate
import com.soywiz.klock.Date

object DateUtil {
    private const val DEFAULT_PATTERN = "yyyy-mm-dd"
    const val READABLE_DATE_PATTERN = "dd MMMM yyyy"

    fun tryParse(date: String): Date? = tryParseDate(date = date, pattern = DEFAULT_PATTERN)
}
