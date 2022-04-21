package com.majorkik.tmdb.impl

import com.soywiz.klock.DateFormat
import com.soywiz.klock.parseDate

fun tryParseToDate(date: String, pattern: String = "yyyy-MM-dd") =
    DateFormat(pattern).runCatching { parseDate(date) }.getOrNull()
