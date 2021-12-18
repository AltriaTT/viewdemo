package com.multitouch.harvic.blogmultitouch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.widget.TextView;

public class TouchScaleTextView extends TextView {
    private int mode = 0;
    private float mOldDist;
    private float mTextSize = 0;

    public TouchScaleTextView(Context context) {
        super(context);
    }

    public TouchScaleTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchScaleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mTextSize == 0) {
            mTextSize = getTextSize();
        }
        switch (event.getActionMasked()) {
        case MotionEvent.ACTION_DOWN:
            mOldDist = 0;
            mode = 1;
            break;
        case MotionEvent.ACTION_UP:
            mode = 0;
            break;
        case MotionEvent.ACTION_POINTER_UP:
            mode -= 1;
            break;
        case MotionEvent.ACTION_POINTER_DOWN:
            mOldDist = spacing(event);
            mode += 1;
            break;

        case MotionEvent.ACTION_MOVE:
            if (mode >= 2) {
                float newDist = spacing(event);
                if (Math.abs(newDist - mOldDist) > 50) {
                    zoom(newDist / mOldDist);
                    mOldDist = newDist;
                }
            }
            break;
        }
        return true;
    }

    private void zoom(float f) {
        mTextSize *= f;
        setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
    }

    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }
}
