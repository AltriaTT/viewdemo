package com.clock.harvic.blogwonderfulview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.clock.harvic.blogclockview.R;

import java.util.ArrayList;

public class PieViewPrincipleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_view_principle);

        PieView pieView = findViewById(R.id.pie_view);
        ArrayList<PieChartBean> datas = new ArrayList<>();
        datas.add(new PieChartBean(Color.RED,30));
        datas.add(new PieChartBean(Color.GREEN,60));
        datas.add(new PieChartBean(Color.GRAY,50));
        datas.add(new PieChartBean(Color.BLUE,40));
        datas.add(new PieChartBean(Color.BLACK,120));
        datas.add(new PieChartBean(Color.YELLOW,60));
        pieView.setData(datas);
        pieView.setProgressAnimation(2000);
    }
}
