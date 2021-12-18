package com.clock.harvic.blogwonderfulview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.clock.harvic.blogclockview.R;

public class VolumeLayout extends FrameLayout {
    private VolumeView mVolumeView;
    public VolumeLayout(@NonNull Context context) {
        super(context);
        init(context);
    }

    public VolumeLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public VolumeLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.volume_layout, this);
        mVolumeView =  view.findViewById(R.id.volume);
    }


    /**
     * 加音量
     */
    public void volumeUp() {
        mVolumeView.volumeUp();
    }

    /**
     * 减音量
     */
    public void volumeDown() {
        mVolumeView.volumeDown();
    }

}
