package com.example.debughao.recyclerview.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.debughao.recyclerview.R;
import com.example.debughao.recyclerview.adapter.MainAdapter;

public class MainActivity extends AppCompatActivity {
  private  RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mRecyclerView= (RecyclerView) findViewById(R.id.recycle);
        initAdapter();
    }
    private void initView() {
        mRecyclerView= (RecyclerView) findViewById(R.id.recycle);
    }

    private void initAdapter() {
        //创建默认的线性LayoutManager=
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);
        MainAdapter adapter = new MainAdapter(this);
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                intent.putExtra("position", position);
               startActivity(intent);
            }
        });
    }
}
