package com.ysered.tooltipsample.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.withStyledAttributes
import com.ysered.tooltipsample.R
import com.ysered.tooltipsample.ext.getPositionOnScreen
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
        // TODO: move to view's attributes?
        private const val MARGIN_RIGHT = 30f
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

    fun showToLeftOf(view: View) {
        tooltipText.measure(0, 0)

        val (x, y) = view.getPositionOnScreen()

        val tooltipX = x - tooltipText.measuredWidth - MARGIN_RIGHT
        val tooltipY = y - tooltipText.measuredHeight / 2f

        setX(tooltipX)
        setY(tooltipY)
        show()
    }
}