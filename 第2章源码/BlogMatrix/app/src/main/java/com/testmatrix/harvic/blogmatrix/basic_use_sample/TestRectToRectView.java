package com.testmatrix.harvic.blogmatrix.basic_use_sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.testmatrix.harvic.blogmatrix.R;

public class TestRectToRectView extends View {

    private int mViewWidth, mViewHeight;
    private Bitmap mBitmap;
    private Matrix mRectMatrix;

    public TestRectToRectView(Context context) {
        super(context);
        init();
    }

    public TestRectToRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TestRectToRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.cat);
        mRectMatrix = new Matrix();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mViewWidth = w;
        mViewHeight = h;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //背景绘制为黄色
        canvas.drawColor(Color.YELLOW);

        RectF src= new RectF(0, 0, mBitmap.getWidth(), mBitmap.getHeight() );
        RectF dst = new RectF(0, 0, mViewWidth, mViewHeight );

        // 核心要点
        mRectMatrix.setRectToRect(src,dst, Matrix.ScaleToFit.CENTER);

        // 根据Matrix绘制一个变换后的图片
        canvas.drawBitmap(mBitmap, mRectMatrix, new Paint());
    }
}
