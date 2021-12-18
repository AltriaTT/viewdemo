package com.example.harvic.msgtoolssec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

public class SlideQQActivity extends AppCompatActivity {
    private SlideMenuGroup mSlideMenuGroup;
    private TextView mMainViewTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_qq);

        LayoutInflater inflater = LayoutInflater.from(this);
        mSlideMenuGroup = (SlideMenuGroup)findViewById(R.id.slide_menu_container);

        //获取mainView及LayoutParams
        View mainView = inflater.inflate(R.layout.slide_content_layout,null,false);
        LayoutParams mainLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        //获取menuView及LayoutParams
        int menuWidth = getResources().getDimensionPixelOffset(R.dimen.slide_menu_width);
        LayoutParams menuLayoutParams = new LayoutParams(menuWidth, LayoutParams.WRAP_CONTENT);
        View menuView = inflater.inflate(R.layout.slide_menu_layout,null,false);

        mSlideMenuGroup.setView(mainView,mainLayoutParams,menuView,menuLayoutParams);

        mMainViewTv = (TextView)mainView.findViewById(R.id.slide_main_view_text);
        //menu处理
        menuView.findViewById(R.id.menu_apple).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                changeMainViewText("苹果");
            }
        });

        menuView.findViewById(R.id.menu_banana).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                changeMainViewText("香蕉");
            }
        });

        menuView.findViewById(R.id.menu_pear).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                changeMainViewText("大鸭梨");
            }
        });
    }

    private void changeMainViewText(String text){
        mMainViewTv.setText(text);
        mSlideMenuGroup.closeMenu();
    }
}
