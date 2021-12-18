package com.example.harvic.msgtoolssec;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DragLayout extends LinearLayout {
    private ViewDragHelper mDragger;

    public DragLayout(Context context) {
        super(context);
        init(context);
    }

    public DragLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DragLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mDragger = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                Log.d("qijian", "tryCaptureView");
                return child.getId() == R.id.tv1 || child.getId() == R.id.tv2;
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                return left;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                return top;
            }

            @Override
            public int getViewHorizontalDragRange(@NonNull View child) {
                return 1;
            }

            @Override
            public void onEdgeTouched(int edgeFlags, int pointerId) {
                super.onEdgeTouched(edgeFlags, pointerId);
                Log.d("qijian", "onEdgeTouched  edgeFlags:" + edgeFlags);
            }

            @Override
            public void onEdgeDragStarted(int edgeFlags, int pointerId) {
                super.onEdgeDragStarted(edgeFlags, pointerId);
                mDragger.captureChildView(findViewById(R.id.tv3), pointerId);
                Log.d("qijian", "onEdgeDragStarted  edgeFlags:" + edgeFlags);
            }

            @Override
            public boolean onEdgeLock(int edgeFlags) {
                Log.d("qijian","onEdgeLock  edgeFlags:"+edgeFlags);
                if (edgeFlags == ViewDragHelper.EDGE_LEFT){
                    return true;
                }
                return false;
            }

            @Override
            public void onViewReleased(@NonNull View releasedChild, float xvel, float yvel) {
                if (releasedChild.getId() == R.id.tv2){
                    TextView tv1= findViewById(R.id.tv1);
                    mDragger.settleCapturedViewAt(tv1.getLeft(),tv1.getTop());
//                    mDragger.smoothSlideViewTo(releasedChild,tv1.getLeft(),tv1.getTop());
                    invalidate();
                }
            }
        });
        mDragger.setEdgeTrackingEnabled(ViewDragHelper.EDGE_LEFT | ViewDragHelper.EDGE_TOP);
    }

    @Override
    public void computeScroll()
    {
        if(mDragger.continueSettling(true))
        {
            invalidate();
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return mDragger.shouldInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragger.processTouchEvent(event);
        return true;
    }


}
