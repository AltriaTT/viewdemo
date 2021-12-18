package com.scroller.harvic.scrollerdemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Scroller;

public class ToggleButtonSec extends ViewGroup {
    private boolean mIsOpen = false;
    private Scroller mScroller;
    private int mSliderWidth,mScrollerWidth;
    public ToggleButtonSec(Context context) {
        super(context);
        init(context);
    }

    public ToggleButtonSec(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ToggleButtonSec(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private View mSlideView,mBgView;

    private void init(Context context){
        mScroller = new Scroller(context);
        setBackgroundResource(R.mipmap.background);

        mBgView = new ImageView(context);
        mBgView.setBackgroundResource(R.mipmap.background);
        addView(mBgView);

        mSlideView = new ImageView(context);
        mSlideView.setBackgroundResource(R.mipmap.slide);
        mSlideView.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mIsOpen) {
                    mScroller.startScroll(-mScrollerWidth, 0, mScrollerWidth, 0, 500);
                } else {
                    mScroller.startScroll(0, 0, - mScrollerWidth, 0, 500);
                }
                mIsOpen = !mIsOpen;
                invalidate();
            }
        });
        addView(mSlideView);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Drawable bgDrawable = getResources().getDrawable(R.mipmap.background);
        setMeasuredDimension(bgDrawable.getIntrinsicWidth(),bgDrawable.getIntrinsicHeight());
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mSliderWidth = getMeasuredWidth() / 2;
        mScrollerWidth = getMeasuredWidth() - mSliderWidth;
        mSlideView.layout(0, 0, mSliderWidth, getMeasuredHeight());

        mBgView.layout(0,0,getMeasuredWidth(),getMeasuredHeight());
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }
}
