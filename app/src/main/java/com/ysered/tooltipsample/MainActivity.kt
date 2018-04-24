package com.ysered.tooltipsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ysered.tooltipsample.ext.vibrateDevice
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showTooltipButton.setOnLongClickListener {
            vibrateDevice()
            tooltip.show()
            true
        }
    }
}
