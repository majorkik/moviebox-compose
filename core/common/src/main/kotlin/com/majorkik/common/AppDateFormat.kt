package com.majorkik.common

import arrow.core.None
import arrow.core.Option
import arrow.core.some
import com.soywiz.klock.Date
import com.soywiz.klock.DateException
import com.soywiz.klock.DateFormat
import com.soywiz.klock.parseDate

object AppDateFormat {
    private const val READABLE_DATE = "dd MMMM yyyy"

    fun parseReadableDate(date: Date?): Option<String> {
        return date?.format(READABLE_DATE)?.some() ?: return None
    }
}

fun tryParseDate(date: String, pattern: String): Date? {
    val dateFormat = DateFormat(pattern)

    return try {
        dateFormat.parseDate(date)
    } catch (exception: DateException) {
        logger.error(exception) { "Error converting string to date" }
        null
    }
}
