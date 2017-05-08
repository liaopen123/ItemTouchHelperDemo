package com.example.pony.itemtouchhelperdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pony.itemtouchhelperdemo.Adapter.MultipleItemAdapter;
import com.example.pony.itemtouchhelperdemo.R;
import com.example.pony.itemtouchhelperdemo.entity.MutiItem;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 多条目的recyclerview使用步骤：
 * 1.不同type的item 的javaBean实现 MultiItemEntity 并且给itemType好赋值
 * 2.适配器继承BaseMultiItemQuickAdapter<MutiItem,BaseViewHolder>  MutiItem为1中的实现类   在convert中进行赋值
 */
public class MultiItemActivity extends AppCompatActivity {

    private ArrayList<String> mDatas;
    @BindView( R.id.recyclerview )
    public RecyclerView mRecyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_item);

        ButterKnife.bind(this);
        ArrayList<MutiItem> datas = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(
//                2, StaggeredGridLayoutManager.VERTICAL);
//        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        //设置适配器
        initDatas();
        for(int i = 0;i<mDatas.size();i++){
            MutiItem muti = new MutiItem(mDatas.get(i));
            datas.add(muti);
        }
        MultipleItemAdapter mAdapter = new MultipleItemAdapter(datas);
        mRecyclerView.setAdapter(mAdapter);


    }






    private void initDatas()
    {
        mDatas = new ArrayList<String>(Arrays.asList("古典乐","轻音乐","流行乐","摇滚乐","轻音乐","流行乐","古典乐","轻音乐","流行乐"));
    }
}
