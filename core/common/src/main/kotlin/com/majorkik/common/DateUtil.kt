package com.majorkik.common

import com.orhanobut.logger.Logger
import com.soywiz.klock.Date
import com.soywiz.klock.DateException
import com.soywiz.klock.DateFormat
import com.soywiz.klock.parseDate

fun tryParseDate(date: String, pattern: String = "dd MMMM yyyy"): Date? {
    val dateFormat = DateFormat(pattern)

    return try {
        dateFormat.parseDate(date)
    } catch (e: DateException) {
        Logger.e(e, "Error converting string to date")
        null
    }
}
