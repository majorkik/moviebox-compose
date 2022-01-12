package com.majorkik.core.ui.extension

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(@StringRes stringResId: Int, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, stringResId, length).show()
}

fun Context.showToast(message: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, length).show()
}
