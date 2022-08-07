package com.majorkik.tmdb.impl.util

import arrow.core.None
import arrow.core.Option
import com.majorkik.common.tryParseDate
import com.soywiz.klock.Date

internal enum class ServerDatePattern(val pattern: String) {
    DEFAULT_SERVER_PATTERN("yyyy-MM-dd")
}

internal fun tryParseDateFromAPI(date: String?): Option<Date> {
    return tryParseDate(
        date = date ?: return None,
        pattern = ServerDatePattern.DEFAULT_SERVER_PATTERN.pattern
    )
}
