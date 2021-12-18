package com.custom.harvic.testcustomctrl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

public class CustomRoundLayout extends LinearLayout {
    private Path mPath = new Path();
    private String mBgColor;

    public CustomRoundLayout(Context context) {
        super(context);
    }

    public CustomRoundLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRoundLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (TextUtils.isEmpty(mBgColor)) {
            Drawable bgDrawable = getBackground();
            if (bgDrawable instanceof  ColorDrawable) {
                ColorDrawable colorDrawable = (ColorDrawable) bgDrawable;
                int color = colorDrawable.getColor();
                mBgColor = "#" + String.format("%08x", color);
                Log.d("qijian", "color:" + color + "   " + mBgColor);
            }
        }

        setBackgroundColor(Color.parseColor("#00FFFFFF"));

        super.onDraw(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        mPath.reset();
        mPath.addRoundRect(new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight()), 50, 50, Direction.CW);
        canvas.save();
        canvas.clipPath(mPath);

        if (!TextUtils.isEmpty(mBgColor)) {
            canvas.drawColor(Color.parseColor(mBgColor));
        }

        super.dispatchDraw(canvas);
        canvas.restore();
    }
}
