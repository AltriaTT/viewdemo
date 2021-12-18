package com.clock.harvic.blogwonderfulview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class VolumeView extends View {
    private static int DEFAULT_DIMENSION;
    private Paint mPaint = new Paint();
    private int mBackgroundColor = 0x60000000;
    private int mBorderWidth = 0;
    private int mVolumeBgColor = 0x80000000;


    private int mRadius;
    private int mCenterX, mCenterY;
    private int mVolumeRadius;

    private RectF mVolumeRect;
    private int mVolumeColor = Color.WHITE;

    private int mVolumeNum;
    private int mMaxVolume = 10;
    private int mUniteDegree = 360 / mMaxVolume;

    private int mAnimatedDegree;

    public VolumeView(Context context) {
        super(context);
        init(context);
    }

    public VolumeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public VolumeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        DEFAULT_DIMENSION = dipToPx(context, 150);
        mBorderWidth = dipToPx(context, 8);
    }

    public int dipToPx(Context context, int dip) {
        float px = context.getResources().getDisplayMetrics().density;
        return (int) (dip * px + 0.5f);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRadius = Math.min(w, h) / 2;
        mVolumeRadius = mRadius - mBorderWidth;
        mCenterX = w / 2;
        mCenterY = h / 2;
        mVolumeRect = new RectF(-mVolumeRadius, -mVolumeRadius, mVolumeRadius, mVolumeRadius);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(DEFAULT_DIMENSION, DEFAULT_DIMENSION);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(DEFAULT_DIMENSION, heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, DEFAULT_DIMENSION);
        } else {
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.translate(mCenterX, mCenterY);
        mPaint.setColor(mBackgroundColor);
        mPaint.setStyle(Style.FILL);
        canvas.drawCircle(0, 0, mRadius, mPaint);

        mPaint.setStyle(Style.STROKE);
        mPaint.setColor(mVolumeBgColor);
        mPaint.setStrokeWidth(mBorderWidth);

        //画音量背景
        canvas.drawCircle(0, 0, mVolumeRadius, mPaint);

        mPaint.setColor(mVolumeColor);
        //画音量
        if (mIsVolumeUp) {
            int num = mVolumeNum - 1 > 0 ? mVolumeNum - 1 : 0;
            canvas.drawArc(mVolumeRect, -90, mUniteDegree * num + mAnimatedDegree, false, mPaint);
        } else {
            int num = mVolumeNum + 1;
            canvas.drawArc(mVolumeRect, -90, mUniteDegree * num - mAnimatedDegree, false, mPaint);
        }
        canvas.restore();
    }



    /**
     * 控制音量增加减少时的动画效果
     */
    private void startAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, mUniteDegree);
        valueAnimator.setDuration(300);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mAnimatedDegree = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
    }

    private boolean mIsVolumeUp = true;

    /**
     * 加音量
     */
    public void volumeUp() {
        mIsVolumeUp = true;
        if (mVolumeNum < mMaxVolume) {
            mVolumeNum++;
            startAnim();
        }
    }

    /**
     * 减音量
     */
    public void volumeDown() {
        mIsVolumeUp = false;
        if (mVolumeNum > 0) {
            mVolumeNum--;
            startAnim();
        }
    }

}
