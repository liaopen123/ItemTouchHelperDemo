package com.example.pony.itemtouchhelperdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.pony.itemtouchhelperdemo.Adapter.GalleryAdapter;
import com.example.pony.itemtouchhelperdemo.R;
import com.example.pony.itemtouchhelperdemo.callback.ItemDragAndSwipeCallback;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView( R.id.recyclerview )
    public RecyclerView mRecyclerView ;
    private ArrayList<Integer> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //设置布局管理器
        initDatas();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(
//                2, StaggeredGridLayoutManager.VERTICAL);
//        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        //设置适配器
        GalleryAdapter mAdapter = new GalleryAdapter(this, mDatas);

        //设置触摸回调
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(mAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);

        Intent intent = new  Intent(this,MultiItemActivity.class);
        startActivity(intent);
    }

    private void initDatas()
    {
        mDatas = new ArrayList<Integer>(Arrays.asList(R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher));
    }

}
