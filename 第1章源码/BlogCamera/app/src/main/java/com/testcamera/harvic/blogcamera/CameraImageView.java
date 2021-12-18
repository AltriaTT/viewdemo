package com.testcamera.harvic.blogcamera;

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

public class CameraImageView extends ImageView {
    private Bitmap mBitmap;
    private Paint mPaint;
    private Camera camera = new Camera();
    private Matrix matrix = new Matrix();
    private int mProgress;
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
        mBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.cat);
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
        camera.save();
        canvas.save();

        mPaint.setAlpha(100);
        canvas.drawBitmap(mBitmap,0,0,mPaint);

        camera.translate(0,0,mProgress);

        // 调节中心点
        int centerX = getWidth()/2;
        int centerY = getHeight()/2;
        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);

        //将Camera位置移动到源图像中心点位置
//        int centerX = getWidth()/2/72;
//        int centerY = getHeight()/2/72;
//        camera.setLocation(centerX,-centerY,camera.getLocationZ());

        camera.getMatrix(matrix);

        canvas.setMatrix(matrix);
        camera.restore();

        super.onDraw(canvas);
        canvas.restore();
    }
}
