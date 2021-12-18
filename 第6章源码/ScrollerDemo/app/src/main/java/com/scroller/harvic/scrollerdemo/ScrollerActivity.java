package com.scroller.harvic.scrollerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ScrollerActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int DISTANCE = 300;
    private ScrollerLinearLayout mScrollerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller);

        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_reset).setOnClickListener(this);

        mScrollerLayout = findViewById(R.id.scroller_root);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
        case R.id.btn_start: {
            mScrollerLayout.startScroll(0, DISTANCE);
        }
        break;
        case R.id.btn_reset: {
            mScrollerLayout.startScroll(DISTANCE, -DISTANCE);
        }
        break;
        }
    }
}
