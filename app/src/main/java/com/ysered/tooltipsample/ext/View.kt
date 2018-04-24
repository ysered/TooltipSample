package com.ysered.tooltipsample.ext

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation

fun View.runFadeInAndFadeOutAnimation(durationMillis: Long) {
    val animation = AlphaAnimation(1f, 0f).apply {
        duration = durationMillis
        repeatMode = Animation.REVERSE
    }
    startAnimation(animation)
}
