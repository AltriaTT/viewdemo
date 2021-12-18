package com.lottie.harvic.bloglottie;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.TextDelegate;

public class LottieTextActivity extends Activity {
    private LottieAnimationView mLottieTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_text);

        mLottieTextView = findViewById(R.id.lottie_test_text);
        findViewById(R.id.btn_change_text).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TextDelegate delegate = new TextDelegate(mLottieTextView);
                delegate.setText("大家好，我是启舰", "启的舰");
                mLottieTextView.setTextDelegate(delegate);
            }
        });
    }
}
