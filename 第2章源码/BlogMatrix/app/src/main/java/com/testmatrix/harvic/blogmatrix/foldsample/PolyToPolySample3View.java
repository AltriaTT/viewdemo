package com.testmatrix.harvic.blogmatrix.foldsample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.testmatrix.harvic.blogmatrix.R;

public class PolyToPolySample3View extends View {
    private Bitmap mBitmap;
    private static int sFoldsNum = 8;
    private int mFoldWidth;
    private float mFactor = 0.8f;
    private Matrix[] mMatrices = new Matrix[sFoldsNum];
    private Paint mSolidPaint = new Paint();
    private Paint mShadowPaint = new Paint();
    private LinearGradient mShadowGradientShader;


    public PolyToPolySample3View(Context context) {
        super(context);
        init();
    }


    public PolyToPolySample3View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PolyToPolySample3View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        for (int i = 0; i < sFoldsNum; i++) {
            mMatrices[i] = new Matrix();
        }
        mBitmap = BitmapFactory.decodeResource(getResources(),
                R.mipmap.sample);
        mFoldWidth = mBitmap.getWidth() / sFoldsNum;

        //初始化阴影相关变量
        int alpha = (int) (255 * (1 - mFactor));
        mShadowGradientShader = new LinearGradient(0, 0, mFoldWidth, 0,
                Color.BLACK, Color.TRANSPARENT, TileMode.CLAMP);
        mSolidPaint.setColor(Color.argb((int) (alpha * 0.8F), 0, 0, 0));
        mShadowPaint.setAlpha(alpha);
        mShadowPaint.setShader(mShadowGradientShader);

        int foldedItemWidth = (int) (mBitmap.getWidth() * mFactor / sFoldsNum);
        float depth = (float) (Math.sqrt(mFoldWidth * mFoldWidth
                - foldedItemWidth * foldedItemWidth) / 2);

        for (int i = 0; i < sFoldsNum; i++) {
            //表示第几个模块，i==0时，表示第一个模块
            boolean isEven = i % 2 == 0;

            int sLeft = mFoldWidth * i;
            int sRight = mFoldWidth * (i + 1);
            float[] src = {sLeft, 0,
                    sRight, 0,
                    sRight, mBitmap.getHeight(),
                    sLeft, mBitmap.getHeight()};
            float[] dst = new float[sFoldsNum];

            dst[0] = foldedItemWidth * i;
            dst[1] = isEven ? 0 : depth;
            dst[2] = foldedItemWidth * (i + 1);
            dst[3] = isEven ? depth : 0;
            dst[4] = foldedItemWidth * (i + 1);
            dst[5] = isEven ? mBitmap.getHeight() + depth : mBitmap.getHeight();
            dst[6] = foldedItemWidth * i;
            dst[7] = isEven ? mBitmap.getHeight() : mBitmap.getHeight() + depth;
            mMatrices[i].setPolyToPoly(src, 0, dst, 0, src.length >> 1);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < sFoldsNum; i++) {
            canvas.save();
            Rect rect = new Rect(mFoldWidth * i, 0, mFoldWidth * (i + 1), getHeight());
            canvas.setMatrix(mMatrices[i]);
            canvas.clipRect(rect);
            canvas.drawBitmap(mBitmap, 0, 0, null);

            canvas.translate(mFoldWidth * i, 0);
            if (i % 2 == 0) {
                canvas.drawRect(0, 0, mFoldWidth, mBitmap.getHeight(), mSolidPaint);
            } else {
                canvas.drawRect(0, 0, mFoldWidth, mBitmap.getHeight(), mShadowPaint);
            }
            canvas.restore();
        }

    }
}