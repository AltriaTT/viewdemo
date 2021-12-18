package com.testcamera.harvic.blogcamera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class Rotate3DActivity extends AppCompatActivity {
    private View mContentRoot;

    private int duration = 600;
    private Rotate3dAnimation openAnimation;
    private Rotate3dAnimation closeAnimation;

    private boolean isOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_3d);

        mContentRoot =  findViewById(R.id.content);

        initOpenAnim();
        initCloseAnim();
    }


    private void initOpenAnim() {
        openAnimation = new Rotate3dAnimation(0, 90,true);
        openAnimation.setDuration(duration);
        openAnimation.setFillAfter(true);
        openAnimation.setInterpolator(new AccelerateInterpolator());
        openAnimation.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                ((ImageView)findViewById(R.id.iv_logo)).setImageResource(R.mipmap.photo2);
                ((ImageView)findViewById(R.id.iv_logo)).setVisibility(View.GONE);
                ((ImageView)findViewById(R.id.iv_logo_2)).setVisibility(View.VISIBLE);
                Rotate3dAnimation rotateAnimation = new Rotate3dAnimation(90, 180,false);
                rotateAnimation.setDuration(duration);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
                mContentRoot.startAnimation(rotateAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void initCloseAnim() {
        closeAnimation = new Rotate3dAnimation(180, 90,true);
        closeAnimation.setDuration(duration);
        closeAnimation.setFillAfter(true);
        closeAnimation.setInterpolator(new AccelerateInterpolator());
        closeAnimation.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                ((ImageView)findViewById(R.id.iv_logo)).setImageResource(R.mipmap.photo1);
                ((ImageView)findViewById(R.id.iv_logo)).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.iv_logo_2)).setVisibility(View.GONE);
                Rotate3dAnimation rotateAnimation = new Rotate3dAnimation(90, 0, false);
                rotateAnimation.setDuration(duration);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
                mContentRoot.startAnimation(rotateAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void onClickView(View v) {
        if (openAnimation.hasStarted() && !openAnimation.hasEnded()) {
            return;
        }
        if (closeAnimation.hasStarted() && !closeAnimation.hasEnded()) {
            return;
        }

        if (isOpen) {
//            ((ImageView)findViewById(R.id.iv_logo)).setImageResource(R.mipmap.photo2);
            mContentRoot.startAnimation(closeAnimation);
        }else {
//            ((ImageView)findViewById(R.id.iv_logo)).setImageResource(R.mipmap.photo1);
            mContentRoot.startAnimation(openAnimation);
        }
        isOpen = !isOpen;
    }
}
