package com.example.harvic.blogrecyclerviewsec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

public class GridItemTouchHelperActivity extends AppCompatActivity {
    private ArrayList<String> mDatas = new ArrayList<>();
    private ItemTouchHelper mItemTouchHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        generateDatas();
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.linear_recycler_view);

        //线性布局
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,5);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));

        RecyclerAdapter adapter = new RecyclerAdapter(this, mDatas);
        mRecyclerView.setAdapter(adapter);

        mItemTouchHelper = new ItemTouchHelper(new MyItemTouchHelperCallBack(mDatas,adapter));
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    private void generateDatas() {
        for (int i = 0; i < 200; i++) {
            mDatas.add("第 " + i + " 个item");
        }
    }
}
