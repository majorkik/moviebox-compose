package com.majorkik.common

import kotlin.math.roundToInt

/**
 * Calculates the percentage of the number
 */
@Suppress("Detekt.MagicNumber")
fun Double.percentOf(from: Int) = ((this / from) * 100).roundToInt()
