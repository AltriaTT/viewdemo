package com.touch.harvic.testtouchevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.second_activity).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
        case R.id.second_activity:{
            startActivity(new Intent(MainActivity.this,SecondActivity.class));

        }
        break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        LogHelper.onLog("MainActivity dispatchTouchEvent",event);
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogHelper.onLog("MainActivity onTouchEvent",event);
        return super.onTouchEvent(event);
    }
}
