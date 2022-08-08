package com.majorkik.test

import io.kotest.data.Row1
import io.kotest.data.row

fun <T> convertToRowArray(elements: List<T>): Array<Row1<T>> {
    return elements.map(::row).toTypedArray()
}
