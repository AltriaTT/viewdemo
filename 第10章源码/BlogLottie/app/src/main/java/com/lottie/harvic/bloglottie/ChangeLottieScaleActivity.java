package com.lottie.harvic.bloglottie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.ScaleXY;
import com.airbnb.lottie.value.SimpleLottieValueCallback;

public class ChangeLottieScaleActivity extends AppCompatActivity {
    private LottieAnimationView mLottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_lottie_scale);

        mLottieAnimationView = findViewById(R.id.lottie_change_scale);

        findViewById(R.id.btn_change_scale).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLottieScale();
            }
        });
    }

    private void changeLottieScale(){
        mLottieAnimationView.addValueCallback(new KeyPath("“未标题-1”轮廓"), LottieProperty.TRANSFORM_SCALE, new SimpleLottieValueCallback<ScaleXY>() {
            @Override
            public ScaleXY getValue(LottieFrameInfo<ScaleXY> frameInfo) {
                ScaleXY originScale = frameInfo.getStartValue();
                ScaleXY destScale = new ScaleXY(originScale.getScaleX()*3f,originScale.getScaleY()*3f);
                return destScale;
            }
        });

    }
}
