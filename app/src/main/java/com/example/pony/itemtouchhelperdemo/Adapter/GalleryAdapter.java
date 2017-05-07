package com.example.pony.itemtouchhelperdemo.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.pony.itemtouchhelperdemo.R;
import com.example.pony.itemtouchhelperdemo.callback.ItemDragAndSwipeCallback;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Pony on 2017/3/19.
 */

public class GalleryAdapter extends RecyclerView.Adapter  implements ItemDragAndSwipeCallback.ItemTouchHelperAdapter{

    private final LayoutInflater mInflater;
    Context context;
    ArrayList<Integer> mDatas;
    public GalleryAdapter(Context context, ArrayList<Integer> mDatas) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        this.mDatas =mDatas;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_horizontal,
                parent, false);
        ViewHolder1 viewHolder = new ViewHolder1(view);
        viewHolder.mImg = (ImageView) view
                .findViewById(R.id.iv);
        viewHolder.linearLayout =(LinearLayout) view
                .findViewById(R.id.ll);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
     int color =  position%2==0? Color.RED : Color.BLUE;
        ViewHolder1 viewHolder1 = (ViewHolder1) holder;
        viewHolder1.linearLayout.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mDatas,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
            mDatas.remove(position);
        notifyItemRemoved(position);
    }


    public static class ViewHolder1  extends RecyclerView.ViewHolder
    {
        public ViewHolder1(View arg0)
        {
            super(arg0);
        }

        ImageView mImg;
        LinearLayout linearLayout;
    }
}
