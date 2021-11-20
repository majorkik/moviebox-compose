package com.majorkik.tmdb.api.util

import com.majorkik.common.tryParseDate
import com.soywiz.klock.Date

object DateUtil {
    const val RELEASE_DATE_PATTERN = "yyyy-mm-dd"
    const val READABLE_DATE_PATTERN = "dd MMMM yyyy"

    fun tryParse(date: String): Date? = tryParseDate(date = date, pattern = RELEASE_DATE_PATTERN)
}
