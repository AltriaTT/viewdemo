package com.scroller.harvic.scrollerdemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Scroller;

public class ToggleButton extends ViewGroup {
    private boolean mIsOpen = false;
    private Scroller mScroller;
    private int mSliderWidth,mScrollerWidth;
    public ToggleButton(Context context) {
        super(context);
        init(context);
    }

    public ToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        mScroller = new Scroller(context);
        setBackgroundResource(R.mipmap.background);
        ImageView slide = new ImageView(context);
        slide.setBackgroundResource(R.mipmap.slide);
        slide.setOnClickListener(new View.OnClickListener(){
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
        addView(slide);
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
        View view = getChildAt(0);
        view.layout(0, 0, mSliderWidth, getMeasuredHeight());
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
