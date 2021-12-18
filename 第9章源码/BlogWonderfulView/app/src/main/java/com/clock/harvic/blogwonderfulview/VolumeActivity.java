package com.clock.harvic.blogwonderfulview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.clock.harvic.blogclockview.R;

public class VolumeActivity extends AppCompatActivity {
    private VolumeLayout mVolumeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        mVolumeLayout =  findViewById(R.id.volumeView);

        findViewById(R.id.buttonAdd).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mVolumeLayout.volumeUp();
            }
        });
        findViewById(R.id.buttonDelete).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mVolumeLayout.volumeDown();
            }
        });

    }
}
