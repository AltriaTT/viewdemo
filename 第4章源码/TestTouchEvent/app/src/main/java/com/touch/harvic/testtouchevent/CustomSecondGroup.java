package com.touch.harvic.testtouchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import static android.view.MotionEvent.ACTION_MOVE;

public class CustomSecondGroup extends LinearLayout {
    public CustomSecondGroup(Context context) {
        super(context);
    }

    public CustomSecondGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSecondGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        LogHelper.onLog("CustomSecondGroup dispatchTouchEvent",event);
//        return true;
//        return false;
//        switch (event.getAction()){
//        case ACTION_MOVE:
//            return false;
//        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        LogHelper.onLog("CustomSecondGroup onInterceptTouchEvent",event);
//        switch (event.getAction()){
//        case ACTION_MOVE:
//            return true;
//        }
        return super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogHelper.onLog("CustomSecondGroup onTouchEvent ",event);
//        requestDisallowInterceptTouchEvent(true);
//        return true;
        return super.onTouchEvent(event);
    }
}
