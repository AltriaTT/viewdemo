package com.testmatrix.harvic.blogmatrix.basic_use_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.testmatrix.harvic.blogmatrix.R;

public class BasicUseActivity extends AppCompatActivity {
    private SeekBar mSeekBar;
    private CameraImageView mCameraImageView;
    private TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_use);
        mCameraImageView = findViewById(R.id.camera_img);
        mTv = findViewById(R.id.tv_progress);

        mSeekBar = findViewById(R.id.btn_progress);
        mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCameraImageView.setProgress(progress);
                mTv.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
