package com.scroller.harvic.scrollerdemo;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button mBtnScrollTo, mBtnScrollBy, mBtnScrollReset;
    private LinearLayout mRoot,mActionRoot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnScrollTo = (Button) findViewById(R.id.btn_scroll_to);
        mBtnScrollBy = (Button) findViewById(R.id.btn_scroll_by);
        mBtnScrollReset = (Button) findViewById(R.id.btn_scroll_reset);
        mRoot = (LinearLayout) findViewById(R.id.layout_root);
        mActionRoot = (LinearLayout) findViewById(R.id.action_root);

        mBtnScrollTo.setOnClickListener(this);
        mBtnScrollBy.setOnClickListener(this);
        mBtnScrollReset.setOnClickListener(this);
        findViewById(R.id.btn_scroller).setOnClickListener(this);
        findViewById(R.id.btn_scroller_toggle_btn).setOnClickListener(this);
        findViewById(R.id.btn_scroller_test_scroll).setOnClickListener(this);
        findViewById(R.id.btn_scroller_full_toggle_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
        case R.id.btn_scroll_to: {
//            mRoot.scrollTo(-50, -50);
            mActionRoot.scrollTo(50,0);
        }
        break;
        case R.id.btn_scroll_by: {
//            mRoot.scrollBy(-50, -50);
            mActionRoot.scrollBy(50,0);
        }
        break;
        case R.id.btn_scroll_reset: {
//            mRoot.scrollTo(0, 0);
            mActionRoot.scrollTo(0,0);
        }
        break;

        case R.id.btn_scroller:{
            Intent intent  = new Intent(this,ScrollerActivity.class);
            startActivity(intent);
        }
        break;
        case R.id.btn_scroller_toggle_btn:{
            Intent intent  = new Intent(this,ToggleBtnActivity.class);
            startActivity(intent);
        }
        break;
        case R.id.btn_scroller_test_scroll:{
            Intent intent  = new Intent(this,TestScrollToActivity.class);
            startActivity(intent);
        }
        break;
        case R.id.btn_scroller_full_toggle_btn:{
            Intent intent  = new Intent(this,WholeToggleButtonActivity.class);
            startActivity(intent);
        }
        break;
        default:
            break;
        }
    }

}