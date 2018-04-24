package com.ysered.tooltipsample.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.withStyledAttributes
import com.ysered.tooltipsample.R
import com.ysered.tooltipsample.ext.runFadeInAndFadeOutAnimation


class TooltipView(
        context: Context,
        attrs: AttributeSet?,
        defaultStyle: Int
) : FrameLayout(context, attrs, defaultStyle) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null)

    companion object {
        const val TOOLTIP_DISPLAY_DURATION_MS = 3000L
    }

    private val tooltipText: TextView

    var text: String = ""
        set(value) {
            tooltipText.text = value
        }

    init {
        val inflater = LayoutInflater.from(context)
        val root = inflater.inflate(R.layout.view_tooltip, this, true)
        tooltipText = root.findViewById(R.id.tooltipText)

        context.withStyledAttributes(attrs, R.styleable.TooltipView) {
            text = getString(R.styleable.TooltipView_android_text)
        }
    }

    fun show() {
        tooltipText.runFadeInAndFadeOutAnimation(TOOLTIP_DISPLAY_DURATION_MS)
    }
}