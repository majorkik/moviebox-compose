package com.majorkik.common

import kotlin.math.roundToInt

/**
 * Calculates the percentage of the number
 */
@Suppress("Detekt.MagicNumber")
fun Double.percentOf(from: Int): Int {
    if (this == 0.0 || from == 0) return 0

    return ((this / from) * 100).roundToInt()
}
