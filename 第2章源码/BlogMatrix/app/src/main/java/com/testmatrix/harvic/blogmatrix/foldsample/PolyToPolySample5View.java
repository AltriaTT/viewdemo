package com.testmatrix.harvic.blogmatrix.foldsample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
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
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.testmatrix.harvic.blogmatrix.R;

public class PolyToPolySample5View extends LinearLayout {
    private static int sFoldsNum = 8;
    private int mFoldWidth;
    private float mFactor = 0.8f;
    private Matrix[] mMatrices = new Matrix[sFoldsNum];
    private Paint mSolidPaint = new Paint();
    private Paint mShadowPaint = new Paint();
    private LinearGradient mShadowGradientShader;
    private int mHeight, mWidth;

    private Bitmap mCanvasBmp;
    private Canvas mCanvas = new Canvas();

    public PolyToPolySample5View(Context context) {
        super(context);
        init();
    }


    public PolyToPolySample5View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PolyToPolySample5View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        for (int i = 0; i < sFoldsNum; i++) {
            mMatrices[i] = new Matrix();
        }
        mShadowGradientShader = new LinearGradient(0, 0, mFoldWidth, 0,
                Color.BLACK, Color.TRANSPARENT, TileMode.CLAMP);
        mShadowPaint.setShader(mShadowGradientShader);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        updateFold();
    }

    private void updateFold() {
        mCanvasBmp = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(),
                Config.ARGB_8888);
        mCanvas.setBitmap(mCanvasBmp);

        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();

        mFoldWidth = mWidth / sFoldsNum;
        //初始化阴影相关变量
        int alpha = (int) (255 * (1 - mFactor));
        mSolidPaint.setColor(Color.argb((int) (alpha * 0.8F), 0, 0, 0));
        mShadowPaint.setAlpha(alpha);

        int foldedItemWidth = (int) (mWidth * mFactor / sFoldsNum);
        float depth = (float) (Math.sqrt(mFoldWidth * mFoldWidth
                - foldedItemWidth * foldedItemWidth) / 2);

        for (int i = 0; i < sFoldsNum; i++) {
            //表示第几个模块，i==0时，表示第一个模块
            boolean isEven = i % 2 == 0;
            int sLeft = mFoldWidth * i;
            int sRight = mFoldWidth * (i + 1);
            float[] src = {sLeft, 0,
                    sRight, 0,
                    sRight, mHeight,
                    sLeft, mHeight};
            float[] dst = new float[sFoldsNum];

            dst[0] = foldedItemWidth * i;
            dst[1] = isEven ? 0 : depth;
            dst[2] = foldedItemWidth * (i + 1);
            dst[3] = isEven ? depth : 0;
            dst[4] = foldedItemWidth * (i + 1);
            dst[5] = isEven ? mHeight : mHeight - depth;
            dst[6] = foldedItemWidth * i;
            dst[7] = isEven ? mHeight - depth : mHeight;
            mMatrices[i].setPolyToPoly(src, 0, dst, 0, src.length >> 1);
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        for (int i = 0; i < sFoldsNum; i++) {
            canvas.save();
            Rect rect = new Rect(mFoldWidth * i, 0, mFoldWidth * (i + 1), mHeight);
            canvas.setMatrix(mMatrices[i]);
            canvas.clipRect(rect);

//            if (i == 0){
//                super.dispatchDraw(mCanvas);
//            }
//            canvas.drawBitmap(mCanvasBmp, 0, 0, null);
            super.dispatchDraw(canvas);

            canvas.translate(mFoldWidth * i, 0);
            if (i % 2 == 0) {
                canvas.drawRect(0, 0, mFoldWidth, mHeight, mSolidPaint);
            } else {
                canvas.drawRect(0, 0, mFoldWidth, mHeight, mShadowPaint);
            }
            canvas.restore();
        }
    }



}