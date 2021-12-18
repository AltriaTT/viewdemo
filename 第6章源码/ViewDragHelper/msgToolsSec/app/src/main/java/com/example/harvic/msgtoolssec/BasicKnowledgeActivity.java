package com.example.harvic.msgtoolssec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/**
 * 基础知识讲解
 */
public class BasicKnowledgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_knowledge);

        findViewById(R.id.tv2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BasicKnowledgeActivity.this,"tv2",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
