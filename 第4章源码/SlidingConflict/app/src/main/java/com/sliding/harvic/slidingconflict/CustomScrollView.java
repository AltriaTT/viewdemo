package com.sliding.harvic.slidingconflict;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView {
    private float mDownPointY;
    private int mConflictHeight;

    public CustomScrollView(Context context) {
        super(context);
        init(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mConflictHeight = context.getResources().getDimensionPixelSize(R.dimen.conflict_height);
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean intercepted = false;
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            intercepted = false;
            mDownPointY = event.getY();
            break;
        case MotionEvent.ACTION_MOVE:
            if (mDownPointY < mConflictHeight) {
                intercepted = false;
            } else {
                intercepted = true;
            }
            break;
        case MotionEvent.ACTION_UP:
            intercepted = false;
            break;
        default:
            break;
        }
        return intercepted;
    }

}
