package com.custom.harvic.testcustomctrl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class CustomLinearLayout extends LinearLayout {
    private ColorMatrix colorMatrix = new ColorMatrix(new float[]{
            0.213f, 0.715f, 0.072f, 0, 0,
            0.213f, 0.715f, 0.072f, 0, 0,
            0.213f, 0.715f, 0.072f, 0, 0,
            0,       0,    0, 1, 0,
    });
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Paint mPaint;

    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (mBitmap == null){
            mBitmap = Bitmap.createBitmap(getWidth(),getHeight(), Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);
            mPaint = new Paint();
            mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        }
        canvas.save();

        super.dispatchDraw(mCanvas);

        canvas.drawBitmap(mBitmap,0,0,mPaint);
        canvas.restore();
    }
}
