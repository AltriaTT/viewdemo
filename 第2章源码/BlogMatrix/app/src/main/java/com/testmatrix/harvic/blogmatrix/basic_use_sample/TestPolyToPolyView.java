package com.testmatrix.harvic.blogmatrix.basic_use_sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class TestPolyToPolyView extends View {
    private static final String TAG = "SetPolyToPoly";
    private Paint mPaint;

    public TestPolyToPolyView(Context context) {
        super(context);
        init();
    }

    public TestPolyToPolyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TestPolyToPolyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

        Matrix matrix = new Matrix();
        float[] src = {0, 0, 400, 0, 0, 400, 400, 400};
        float[] dst = {100, 200, 450, 440, 120, 720, 810, 940};
        matrix.setPolyToPoly(src,0,dst,0,1);

        //根据映射，所得矩阵
        Log.d("qijian","matrix:"+matrix.toShortString());

        //根据矩阵，再次映射src数组，看得到的数组与dst数组有什么关联
        Log.d("qijian","before:"+arrayToString(src));
        matrix.mapPoints(src);
        Log.d("qijian"," after:"+arrayToString(src));
        Log.d("qijian","   dst:"+arrayToString(dst));

        //画面图像
        mPaint.setStrokeWidth(10);
        canvas.translate(10, 10);
        Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(400, 0);
        path.lineTo(400, 400);
        path.lineTo(0, 400);
        path.close();
        canvas.drawPath(path, mPaint);

        mPaint.setColor(Color.RED);

        path.reset();
        path.moveTo(100, 200);
        path.lineTo(450, 440);
        path.lineTo(810, 940);
        path.lineTo(120, 720);
        path.close();
        canvas.drawPath(path,mPaint);


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

