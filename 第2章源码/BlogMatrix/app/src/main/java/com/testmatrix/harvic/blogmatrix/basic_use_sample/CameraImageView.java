package com.testmatrix.harvic.blogmatrix.basic_use_sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.testmatrix.harvic.blogmatrix.R;

public class CameraImageView extends ImageView {
    private Bitmap mBitmap;
    private Paint mPaint;
    private Matrix matrix = new Matrix();
    private int mProgress=1;
    public CameraImageView(Context context) {
        super(context);
        init();
    }

    public CameraImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CameraImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.cat);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public void setProgress(int progress){
        Log.d("qijian","progress:"+progress);
        mProgress = progress;
        postInvalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        mPaint.setAlpha(100);
        canvas.drawBitmap(mBitmap,0,0,mPaint);

        matrix.reset();
        matrix.setTranslate(0,mProgress);
//        matrix.setRotate(mProgress,0,0);
//        matrix.setRotate(mProgress,50,50);
        
        canvas.setMatrix(matrix);
        super.onDraw(canvas);
        canvas.restore();
    }
}
