package com.tientham.weather.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.tientham.weather.R

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-19.
 */
class RoundedButton: AppCompatButton {

    constructor(ctx: Context) : super(ctx) {
        init()
    }

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs) {
        init()
    }

    constructor(ctx: Context, attrs: AttributeSet, defStyleAttr: Int) : super(ctx, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        background = ContextCompat.getDrawable(context, R.drawable.btn_selector)
        isAllCaps = false
    }
}