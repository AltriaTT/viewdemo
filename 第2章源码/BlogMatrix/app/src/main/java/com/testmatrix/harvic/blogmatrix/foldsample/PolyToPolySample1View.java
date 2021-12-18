package com.testmatrix.harvic.blogmatrix.foldsample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.testmatrix.harvic.blogmatrix.R;

public class PolyToPolySample1View extends View {
    private Bitmap mBitmap;
    private Matrix mMatrix;
    private static int sTransHeight = 100;
    private static int sFoldsNum = 8;
    private int mFoldWidth;

    public PolyToPolySample1View(Context context) {
        super(context);
        init();
    }


    public PolyToPolySample1View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PolyToPolySample1View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(),
                R.mipmap.sample);
        mFoldWidth = mBitmap.getWidth()/sFoldsNum;
        mMatrix = new Matrix();
        float[] src = { 0, 0,
                mBitmap.getWidth(), 0,
                mBitmap.getWidth(), mBitmap.getHeight(),
                0, mBitmap.getHeight() };
        float[] dst = { 0, 0,
                mBitmap.getWidth(), sTransHeight,
                mBitmap.getWidth(), mBitmap.getHeight() + sTransHeight,
                0, mBitmap.getHeight() };
        mMatrix.setPolyToPoly(src, 0, dst, 0, src.length >> 1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        Rect rect = new Rect(0,0,mFoldWidth,getHeight());
        canvas.setMatrix(mMatrix);
        canvas.clipRect(rect);
        canvas.drawBitmap(mBitmap,0,0, null);
        canvas.restore();
    }
}