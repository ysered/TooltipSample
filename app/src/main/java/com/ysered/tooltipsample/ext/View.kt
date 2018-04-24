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

fun View.getPositionOnScreen(): Pair<Int, Int> {
    val coordinates = IntArray(2)
    getLocationOnScreen(coordinates)
    val x = coordinates[0]
    val y = coordinates[1] - context.actionBarHeight
    return Pair(x, y)
}