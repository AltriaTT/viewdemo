package com.multitouch.harvic.blogmultitouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MultiTouchView extends View {
    // 用于判断第2个手指是否存在
    private boolean haveSecondPoint = false;
    // 记录第2个手指第位置
    private PointF point = new PointF(0, 0);
    private Paint mDefaultPaint = new Paint();

    public MultiTouchView(Context context) {
        super(context);
        init();
    }

    public MultiTouchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MultiTouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mDefaultPaint.setColor(Color.WHITE);
        mDefaultPaint.setAntiAlias(true);
        mDefaultPaint.setTextAlign(Paint.Align.CENTER);
        mDefaultPaint.setTextSize(30);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = event.getActionIndex();

        switch (event.getActionMasked()) {
        case MotionEvent.ACTION_POINTER_DOWN:
            // 判断是否是第2个手指按下
            if (event.getPointerId(index) == 1) {
                haveSecondPoint = true;
                point.set(event.getX(), event.getY());
            }
            break;
        case MotionEvent.ACTION_POINTER_UP:
            // 判断抬起的手指是否是第2个
            if (event.getPointerId(index) == 1) {
                haveSecondPoint = false;
            }
            break;
        case MotionEvent.ACTION_MOVE:

            try {
                if (haveSecondPoint) {
                    // 通过 pointerId 来获取 pointerIndex
                    int pointerIndex = event.findPointerIndex(1);
                    // 通过 pointerIndex 来取出对应的坐标
                    point.set(event.getX(pointerIndex), event.getY(pointerIndex));
                }
            } catch (Exception e) {
                haveSecondPoint = false;
            }
            break;
        case MotionEvent.ACTION_UP:
            haveSecondPoint = false;
            break;
        }

        invalidate();   // 刷新

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawColor(Color.GREEN);
        // 如果屏幕上有第2个手指则绘制出来其位置
        if (haveSecondPoint) {
            canvas.drawCircle(point.x, point.y, 50, mDefaultPaint);
        }
        canvas.save();
        canvas.translate(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
        canvas.drawText("追踪第2个按下手指的位置", 0, 0, mDefaultPaint);
        canvas.restore();
    }
}

