package com.lottie.harvic.bloglottie;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;

public class LottieImgActivity extends AppCompatActivity {
    private LottieAnimationView mLottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_img);
        mLottieAnimationView = findViewById(R.id.lottie_test_img);

        //初始化时替换照片
        changeLottieImage();

        findViewById(R.id.btn_change_image).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.boy);
                mLottieAnimationView.updateBitmap("image_0", bitmap);
            }
        });
    }

    private void changeLottieImage(){
        LottieTask<LottieComposition> task = LottieCompositionFactory.fromAsset(this, "data.json");
        task.addListener(new LottieListener<LottieComposition>() {
            @Override
            public void onResult(LottieComposition result) {
                mLottieAnimationView.setComposition(result);

                //加载图片
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.flower);
                mLottieAnimationView.updateBitmap("image_0", bitmap);

                //运行动画
                mLottieAnimationView.playAnimation();
            }
        });
    }
}
