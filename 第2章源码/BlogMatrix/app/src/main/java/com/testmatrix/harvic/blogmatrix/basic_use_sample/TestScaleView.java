package com.testmatrix.harvic.blogmatrix.basic_use_sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class TestScaleView extends View {
    private Paint mPaint;

    public TestScaleView(Context context) {
        super(context);
        init();
    }

    public TestScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TestScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        RectF rect = new RectF(0, 200, 300, 0);   // 矩形区域

        Matrix matrix = new Matrix();
        matrix.preTranslate(getWidth() / 2, getHeight() / 2);
        canvas.setMatrix(matrix);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(rect, mPaint);

        Matrix tmpMatrix = new Matrix();
        tmpMatrix.setSinCos(1, 0);
        matrix.preConcat(tmpMatrix);

        canvas.setMatrix(matrix);
        mPaint.setColor(Color.RED);
        canvas.drawRect(rect, mPaint);

        canvas.drawCircle(0, 0, 5, mPaint);

        canvas.restore();
    }

    private String arrayToString(float[] array) {
        StringBuilder builder = new StringBuilder("");
        for (float num : array) {
            builder.append((int) num).append(",");
        }
        return builder.toString();
    }
}
