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
import android.view.animation.AccelerateInterpolator;

import java.util.ArrayList;

public class PieView extends View {
    private Context mContext;
    private Paint mPaint;
    private int DEFAULT_DIMENSION;
    private int mRadius;
    private int mCenterX, mCenterY;
    private RectF mCircleRect;
    private ArrayList<PieChartBean> mPieDataList = new ArrayList();
    private ValueAnimator mProgressAnimator;
    private float mAnimatedValue;

    public PieView(Context context) {
        super(context);
        init(context);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mPaint = new Paint();
        DEFAULT_DIMENSION = dipToPx(context, 50);
        mCircleRect = new RectF();
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

    public int dipToPx(Context context, int dip) {
        float px = context.getResources().getDisplayMetrics().density;
        return (int) (dip * px + 0.5f);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        int sideLength = Math.min(w, h);
        mRadius = sideLength / 2;
        mCenterX = w / 2;
        mCenterY = h / 2;

        //描边宽度设定为圆半径的0.3倍
        float strokeWidth = mRadius * 0.3f;
        mPaint.setStrokeWidth(strokeWidth);

        float rectSide = mRadius - strokeWidth/2;
        mCircleRect.set(-rectSide,-rectSide,rectSide,rectSide);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.translate(mCenterX,mCenterY);

        mPaint.setStyle(Style.STROKE);
        mPaint.setColor(Color.RED);

        int startAngle = 0;
        for (PieChartBean chartBean : mPieDataList) {
            float sweepAngle = chartBean.getPercentage();
            float drawAngle = Math.min(sweepAngle, mAnimatedValue - startAngle);
            if (drawAngle > 0) {
                mPaint.setColor(chartBean.getColor());
                canvas.drawArc(mCircleRect, startAngle, drawAngle, false, mPaint);
            }
            startAngle += sweepAngle;
        }

        canvas.restore();
    }


    public void setData(ArrayList pieChatDatas) {
        mPieDataList.clear();
        if (pieChatDatas == null || pieChatDatas.size() == 0) {
            return;
        }
        mPieDataList.addAll(pieChatDatas);
    }


    //设置进度条动画
    public void setProgressAnimation(long duration) {
        if (mProgressAnimator != null && mProgressAnimator.isRunning()) {
            mProgressAnimator.cancel();
            mProgressAnimator.start();
        } else {
            mProgressAnimator = ValueAnimator.ofFloat(0, 360).setDuration(duration);
            mProgressAnimator.setInterpolator(new AccelerateInterpolator());
            mProgressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    /**每次要绘制的圆弧角度**/
                    mAnimatedValue = (float) animation.getAnimatedValue();
                    invalidate();
                }
            });
            mProgressAnimator.start();
        }
    }
}
