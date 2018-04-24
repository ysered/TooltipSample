package com.ysered.tooltipsample.ext

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator

const val DEFAULT_VIBRATION_DURATION_MS = 500L

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