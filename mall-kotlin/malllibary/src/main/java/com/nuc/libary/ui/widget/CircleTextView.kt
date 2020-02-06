package com.mall.library.ui.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PaintFlagsDrawFilter
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatTextView

class CircleTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    AppCompatTextView(context, attrs) {

    private val mPaint = Paint()
    private val mFilter = PaintFlagsDrawFilter(
        0,
        Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG
    )

    init {
        mPaint.color = Color.WHITE
        mPaint.isAntiAlias = true
    }

    fun setCircleBackground(@ColorInt color: Int) {
        mPaint.color = color
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = measuredWidth
        val height = maxHeight
        val max = Math.max(width, height)
        setMeasuredDimension(max, max)
    }

    override fun draw(canvas: Canvas) {
        canvas.drawFilter = mFilter
        canvas.drawCircle(
            (width / 2).toFloat(), (height / 2).toFloat(),
            (Math.max(width, height) / 2).toFloat(), mPaint
        )
        super.draw(canvas)
    }
}