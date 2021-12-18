package com.multitouch.harvic.blogmultitouch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class SingleDragImgView extends ImageView {
    private int mLeft, mTop;
    private float mStartX,mStartY;
    public SingleDragImgView(Context context) {
        super(context);
    }

    public SingleDragImgView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SingleDragImgView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            mStartX = event.getX();
            mStartY = event.getY();
            mLeft = getLeft();
            mTop = getTop();
            break;
        case MotionEvent.ACTION_MOVE:
            mLeft = (int) (mLeft + event.getX() - mStartX);
            mTop = (int) (mTop + event.getY() - mStartY);

            layout(mLeft, mTop, mLeft + getWidth(), mTop + getHeight());

            break;
        case MotionEvent.ACTION_UP:
            break;
        }

        return true;
    }
}
