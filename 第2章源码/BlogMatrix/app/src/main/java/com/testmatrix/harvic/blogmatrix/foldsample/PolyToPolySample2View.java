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

public class PolyToPolySample2View extends View {
    private Bitmap mBitmap;
    private Matrix mMatrix;
    private static int sFoldsNum = 8;
    private int mFoldWidth;
    private float mFactor = 0.8f;


    public PolyToPolySample2View(Context context) {
        super(context);
        init();
    }


    public PolyToPolySample2View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PolyToPolySample2View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(),
                R.mipmap.sample);
        mFoldWidth = mBitmap.getWidth() / sFoldsNum;

        int foldedItemWidth = (int) (mBitmap.getWidth() * mFactor / sFoldsNum);
        float depth = (float) (Math.sqrt(mFoldWidth * mFoldWidth
                - foldedItemWidth * foldedItemWidth));

        mMatrix = new Matrix();

        float[] src = { mFoldWidth, 0,
                mFoldWidth *2, 0,
                mFoldWidth *2, mBitmap.getHeight(),
                mFoldWidth, mBitmap.getHeight() };
        float[] dst = { foldedItemWidth, depth,
                foldedItemWidth*2, 0,
                foldedItemWidth*2, mBitmap.getHeight(),
                foldedItemWidth, mBitmap.getHeight()+depth };
        mMatrix.setPolyToPoly(src, 0, dst, 0, src.length >> 1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        Rect rect = new Rect(mFoldWidth, 0, mFoldWidth*2, getHeight());
        canvas.setMatrix(mMatrix);
        canvas.clipRect(rect);
        canvas.drawBitmap(mBitmap,0,0, null);
        canvas.restore();
    }
}