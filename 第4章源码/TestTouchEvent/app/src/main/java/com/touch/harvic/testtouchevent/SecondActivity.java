package com.touch.harvic.testtouchevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        LogHelper.onLog("SecondActivity dispatchTouchEvent",event);
//        return false;
        return super.dispatchTouchEvent(event);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogHelper.onLog("SecondActivity onTouchEvent",event);
        return super.onTouchEvent(event);
    }
}
