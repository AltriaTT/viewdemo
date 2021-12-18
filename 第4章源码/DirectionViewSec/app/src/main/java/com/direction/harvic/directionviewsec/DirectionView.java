package com.direction.harvic.directionviewsec;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DirectionView extends LinearLayout implements View.OnClickListener {
    private Context mContext;

    public DirectionView(Context context) {
        super(context);
        init(context);
    }

    public DirectionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DirectionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.direction_view_layout, this);

        findViewById(R.id.direction_up).setOnClickListener(this);
        findViewById(R.id.direction_down).setOnClickListener(this);
        findViewById(R.id.direction_left).setOnClickListener(this);
        findViewById(R.id.direction_right).setOnClickListener(this);
        findViewById(R.id.direction_ok).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.direction_up: {
            Toast.makeText(mContext, "up clicked", Toast.LENGTH_SHORT).show();
        }
        break;
        case R.id.direction_down: {
            Toast.makeText(mContext, "down clicked", Toast.LENGTH_SHORT).show();
        }
        break;
        case R.id.direction_left: {
            Toast.makeText(mContext, "left clicked", Toast.LENGTH_SHORT).show();
        }
        break;
        case R.id.direction_right: {
            Toast.makeText(mContext, "right clicked", Toast.LENGTH_SHORT).show();
        }
        break;
        case R.id.direction_ok: {
            Toast.makeText(mContext, "ok clicked", Toast.LENGTH_SHORT).show();
        }
        break;
        }
    }

    private float lastX = 0, lastY = 0;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
        case MotionEvent.ACTION_DOWN:
            //记录DOWN事件的点击位置，因为不拦截DOWN事件，移动的时候需要这个起点坐标来计算距离。
            lastX = ev.getX();
            lastY = ev.getY();
            break;
        case MotionEvent.ACTION_MOVE:
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            //进行移动操作
            int offX = (int) (event.getX() - lastX);
            int offY = (int) (event.getY() - lastY);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)getLayoutParams();
            params.leftMargin = params.leftMargin + offX;
            params.topMargin += offY;
            setLayoutParams(params);

            return true;
        }
        return super.onTouchEvent(event);
    }
}
