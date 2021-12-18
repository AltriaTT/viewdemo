package com.touch.harvic.testtouchevent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import static android.view.MotionEvent.ACTION_MOVE;

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {
    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        LogHelper.onLog("CustomTextView dispatchTouchEvent",event);
//        switch (event.getAction()){
//        case ACTION_MOVE:
//            return false;
//        }
        return super.dispatchTouchEvent(event);
//        return true;
//        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogHelper.onLog("CustomTextView onTouchEvent",event);
//        return super.onTouchEvent(event);
        return true;
    }
}
