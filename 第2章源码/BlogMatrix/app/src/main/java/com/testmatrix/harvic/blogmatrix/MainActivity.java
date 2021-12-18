package com.testmatrix.harvic.blogmatrix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.testmatrix.harvic.blogmatrix.basic_use_sample.BasicUseActivity;
import com.testmatrix.harvic.blogmatrix.basic_use_sample.TestPolyActivity;
import com.testmatrix.harvic.blogmatrix.basic_use_sample.TestRectToRectActivity;
import com.testmatrix.harvic.blogmatrix.basic_use_sample.TestScaleActivity;
import com.testmatrix.harvic.blogmatrix.foldsample.FoldPrinciple1Activity;
import com.testmatrix.harvic.blogmatrix.foldsample.FoldPrinciple2Activity;
import com.testmatrix.harvic.blogmatrix.foldsample.FoldPrinciple3Activity;
import com.testmatrix.harvic.blogmatrix.foldsample.FoldPrinciple4Activity;
import com.testmatrix.harvic.blogmatrix.foldsample.FoldPrinciple5Activity;
import com.testmatrix.harvic.blogmatrix.foldsample.FoldPrinciple6Activity;
import com.testmatrix.harvic.blogmatrix.foldsample.FoldPrinciple7Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.translate_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BasicUseActivity.class));
            }
        });

        findViewById(R.id.scale_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestScaleActivity.class));
            }
        });

        findViewById(R.id.poly_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestPolyActivity.class));
            }
        });

        findViewById(R.id.rect_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestRectToRectActivity.class));
            }
        });

        findViewById(R.id.fold_sample1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FoldPrinciple1Activity.class));
            }
        });

        findViewById(R.id.fold_sample2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FoldPrinciple2Activity.class));
            }
        });

        findViewById(R.id.fold_sample3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FoldPrinciple3Activity.class));
            }
        });

        findViewById(R.id.fold_sample4).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FoldPrinciple4Activity.class));
            }
        });

        findViewById(R.id.fold_sample5).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FoldPrinciple5Activity.class));
            }
        });

        findViewById(R.id.fold_sample6).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FoldPrinciple6Activity.class));
            }
        });

        findViewById(R.id.fold_sample7).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FoldPrinciple7Activity.class));
            }
        });
    }
}
