package com.clock.harvic.blogwonderfulview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.clock.harvic.blogclockview.R;

public class ClockImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_image_view);

        ClockImageView clockImageView = findViewById(R.id.clock_img_view);
        clockImageView.performAnimation();
    }
}
