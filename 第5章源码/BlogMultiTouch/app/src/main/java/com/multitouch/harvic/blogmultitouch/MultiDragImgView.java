package com.multitouch.harvic.blogmultitouch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MultiDragImgView extends ImageView {
    private int mLeft, mTop;
    private float mStartX, mStartY;

    public MultiDragImgView(Context context) {
        super(context);
    }

    public MultiDragImgView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MultiDragImgView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {

        case MotionEvent.ACTION_DOWN:
            mStartX = event.getX();
            mStartY = event.getY();
            mLeft = getLeft();
            mTop = getTop();
            break;
        case MotionEvent.ACTION_MOVE:
            int index = event.findPointerIndex(0);
            if (index == -1) {
                return false;
            }
            mLeft = (int) (mLeft + event.getX(index) - mStartX);
            mTop = (int) (mTop + event.getY(index) - mStartY);

            layout(mLeft, mTop, mLeft + getWidth(), mTop + getHeight());
            break;
        case MotionEvent.ACTION_UP:
            break;
        }
        return true;
    }
}
