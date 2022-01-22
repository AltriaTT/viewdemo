package com.example.viewdemo.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.FrameLayout
import androidx.core.view.children
import com.example.viewdemo.R

class MyGridView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {
    private val colors = arrayListOf(Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA)

    fun initView(num: Int) {
        Log.e("TAG", "initView")
        removeAllViews()
        for (i in 0 until num) {
            inflate(
                context,
                R.layout.item_view,
                null
            ).apply {
                setBackgroundColor(colors[i])
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var width = MeasureSpec.getSize(widthMeasureSpec)
        var height = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            measureChild(child, widthMeasureSpec, heightMeasureSpec)
            if (i == 0)
                height = child.measuredHeight * (childCount / 2 + 1)
        }
        setMeasuredDimension(width, height)
    }

    override fun measureChild(
        child: View,
        parentWidthMeasureSpec: Int,
        parentHeightMeasureSpec: Int
    ) {
        Log.e("TAG", "measureChild")
        val onlyOne = childCount == 1
        val merge = childCount > 1 && childCount % 2 != 0
        val index = children.indexOf(child)

        val lp = child.layoutParams

        val parentWidth = MeasureSpec.getSize(parentWidthMeasureSpec)
        val childDefHeight = lp.height

        Log.e("TAG", "index:$index,childDefHeight:$childDefHeight,parentWidth:$parentWidth")
        if (onlyOne) {
            child.measure(
                MeasureSpec.makeMeasureSpec(
                    parentWidth,
                    MeasureSpec.EXACTLY
                ),
                MeasureSpec.makeMeasureSpec(
                    childDefHeight,
                    MeasureSpec.EXACTLY
                )
            )
        } else if (merge && index == childCount - 1) {
            child.measure(
                MeasureSpec.makeMeasureSpec(
                    parentWidth / 2,
                    MeasureSpec.EXACTLY
                ),
                MeasureSpec.makeMeasureSpec(
                    childDefHeight * 2,
                    MeasureSpec.EXACTLY
                )
            )
        } else {
            child.measure(
                MeasureSpec.makeMeasureSpec(
                    parentWidth / 2,
                    MeasureSpec.EXACTLY
                ),
                MeasureSpec.makeMeasureSpec(
                    childDefHeight,
                    MeasureSpec.EXACTLY
                )
            )
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        Log.e("TAG", "onLayout")
        children.forEachIndexed { index, child ->
            Log.e("TAG", "index:$index,Height:${child.measuredHeight},Width:${child.measuredWidth}")
            val onlyOne = childCount == 1
            val merge = childCount > 1 && childCount % 2 != 0

            val row = index / 2
            val column = index % 2

            if (merge && index == childCount - 2) {
                child.layout(
                    0,
                    (row + 1) * child.measuredHeight,
                    child.measuredWidth,
                    (row + 2) * child.measuredHeight
                )
            } else if (merge && index == childCount - 1) {
                child.layout(
                    child.measuredWidth,
                    (row - 1) * (child.measuredHeight / 2),
                    child.measuredWidth * 2,
                    (row + 1) * (child.measuredHeight / 2)
                )
            } else {
                child.layout(
                    column * child.measuredWidth,
                    row * child.measuredHeight,
                    (column + 1) * child.measuredWidth,
                    (row + 1) * child.measuredHeight
                )
            }
        }
    }
}
