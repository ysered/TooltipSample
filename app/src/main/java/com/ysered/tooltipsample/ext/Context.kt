package com.ysered.tooltipsample.ext

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.TypedValue

const val DEFAULT_VIBRATION_DURATION_MS = 500L

@Suppress("DEPRECATION")
fun Context.vibrateDevice(duration: Long = DEFAULT_VIBRATION_DURATION_MS) {
    val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
    vibrator?.let {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            it.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(duration)
        }
    }
}

val Context.actionBarHeight: Int
    get() {
        val outValue = TypedValue()
        val canResolveAttribute = theme.resolveAttribute(android.R.attr.actionBarSize, outValue, true)
        return if (canResolveAttribute) {
            TypedValue.complexToDimensionPixelSize(outValue.data, resources.displayMetrics)
        } else {
            0
        }
    }