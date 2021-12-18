package com.lottie.harvic.bloglottie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends Activity {

    private LottieAnimationView mLottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_lottie_basic_use_activity).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LottieBasicAcitity.class));
            }
        });

        findViewById(R.id.btn_lottie_text_activity).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LottieTextActivity.class));
            }
        });

        findViewById(R.id.btn_lottie_img_activity).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LottieImgActivity.class));
            }
        });

        findViewById(R.id.btn_lottie_scale_activity).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ChangeLottieScaleActivity.class));
            }
        });

        findViewById(R.id.btn_lottie_fill_activity).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ChangeLottieColorActivity.class));
            }
        });



//        mLottieAnimationView = (LottieAnimationView) findViewById(R.id.test_url_load);
//        mLottieTextView = findViewById(R.id.test_text);



    }
}
