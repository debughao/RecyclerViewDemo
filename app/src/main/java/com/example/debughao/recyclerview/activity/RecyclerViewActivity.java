package com.example.debughao.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.debughao.recyclerview.R;
import com.example.debughao.recyclerview.adapter.GridAdapter;
import com.example.debughao.recyclerview.adapter.ListAdapter;
import com.example.debughao.recyclerview.adapter.StaggeredGridAdapter;
import com.example.debughao.recyclerview.constant.DataSources;
import com.example.debughao.recyclerview.layoutManager.HeightWrapLinearLayoutManager;

public class RecyclerViewActivity extends AppCompatActivity {

    private int extra;
    private RecyclerView recycle_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        extra = getIntent().getIntExtra("position", -1);
        initView();
    }
    private void initView() {
        recycle_item = (RecyclerView) findViewById(R.id.recycle_item);
        initData();
    }
    private void initData() {
        if(extra == -1) return;
      //  getActionBar().setTitle("RecyclerView--" + MainAdapter.contents[extra]);
        // 列表布局
        if(extra == 0 || extra == 1){
            LinearLayoutManager vLayoutManager = new LinearLayoutManager(this);
            vLayoutManager.setOrientation( RecyclerView.VERTICAL);
            HeightWrapLinearLayoutManager  hLayoutManager=new HeightWrapLinearLayoutManager(this);
            hLayoutManager.setOrientation( RecyclerView.HORIZONTAL);
            recycle_item.setLayoutManager(extra == 1? hLayoutManager:vLayoutManager);
            recycle_item.setAdapter(new ListAdapter(this, extra == 0, DataSources.IMAGECONTENTS));
            return;
        }

        // 网格布局
        if(extra == 2 || extra == 3){
            GridLayoutManager layoutManager = new GridLayoutManager(this, 3); //第二个参数是列数
            layoutManager.setOrientation(extra == 3 ? RecyclerView.HORIZONTAL : RecyclerView.VERTICAL);
            recycle_item.setLayoutManager(layoutManager);
            recycle_item.setAdapter(new GridAdapter(this, extra == 2 , DataSources.IMAGECONTENTS));
            return;
        }

        //瀑布流布局
        if(extra == 4 || extra == 5){
            // 第一个参数:列数;第二个参数排列方式
            StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(extra == 5?1:2, extra == 5 ? RecyclerView.HORIZONTAL : RecyclerView.VERTICAL);
            recycle_item.setLayoutManager(layoutManager);
            recycle_item.setAdapter(new StaggeredGridAdapter(this, extra == 4 , DataSources

                    .IMAGECONTENTS));
            return;
        }
    }
}
