package com.lottie.harvic.bloglottie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;

public class ChangeLottieColorActivity extends AppCompatActivity {
    private LottieAnimationView mLottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_lottie_color);

        mLottieAnimationView = findViewById(R.id.lottie_change_color);

        findViewById(R.id.btn_change_color).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLottieScale();
            }
        });
    }

    private void changeLottieScale() {
        mLottieAnimationView.addValueCallback(new KeyPath("“未标题-1”轮廓", "组 1", "填充 1"), LottieProperty.COLOR, new SimpleLottieValueCallback<Integer>() {
            @Override
            public Integer getValue(LottieFrameInfo<Integer> frameInfo) {
                return new Integer(0xff00000);
            }
        });
    }
}
