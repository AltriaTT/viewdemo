package com.touch.harvic.testtouchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;

public class CustomFirstGroup extends LinearLayout {
    public CustomFirstGroup(Context context) {
        super(context);
    }

    public CustomFirstGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomFirstGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        LogHelper.onLog("CustomFirstGroup dispatchTouchEvent",event);
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        LogHelper.onLog("CustomFirstGroup onInterceptTouchEvent",event);

        return super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogHelper.onLog("CustomFirstGroup onTouchEvent",event);
        return super.onTouchEvent(event);
//        return false;
//        return true;
    }
}
