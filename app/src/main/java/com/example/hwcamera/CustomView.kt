package com.example.hwcamera


import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CustomView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint().apply {
        color = Color.BLACK
        alpha = 100
        style = Paint.Style.FILL
    }

    private val framePaint = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.STROKE
        strokeWidth = 4f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width.toFloat()
        val height = height.toFloat()

        // Kích thước ô vuông
        val frameWidth = width * 0.7f
        val frameHeight = frameWidth

        // Vị trí của ô vuông (ở giữa)
        val frameLeft = (width - frameWidth) / 2
        val frameTop = (height - frameHeight) / 2
        val frameRight = frameLeft + frameWidth
        val frameBottom = frameTop + frameHeight

        // Vẽ phần mờ xung quanh ô vuông
        canvas.drawRect(0f, 0f, width, frameTop, paint)
        canvas.drawRect(0f, frameTop, frameLeft, frameBottom, paint)
        canvas.drawRect(frameRight, frameTop, width, frameBottom, paint)
        canvas.drawRect(0f, frameBottom, width, height, paint)

        // Vẽ khung ô vuông
        canvas.drawRect(frameLeft, frameTop, frameRight, frameBottom, framePaint)
    }
}
