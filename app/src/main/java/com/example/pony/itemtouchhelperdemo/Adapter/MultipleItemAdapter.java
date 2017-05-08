package com.example.pony.itemtouchhelperdemo.Adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pony.itemtouchhelperdemo.R;
import com.example.pony.itemtouchhelperdemo.entity.MutiItem;

import java.util.List;

/**
 * Created by liaopenghui on 2017/5/8.
 */

public class MultipleItemAdapter extends BaseMultiItemQuickAdapter<MutiItem,BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultipleItemAdapter(List<MutiItem> data) {
        super(data);
//        addItemType(MultipleItem.TEXT, R.layout.item_text_view);
  addItemType(MutiItem.POPTEXT, R.layout.multiple_item_pop);
  addItemType(MutiItem.CLASSCALMUSIC, R.layout.multiple_item_classical);
  addItemType(MutiItem.LIGHTLMUSIC, R.layout.multiple_item_light);
    }

    @Override
    protected void convert(BaseViewHolder helper, MutiItem mutiItemtem) {
        helper.setText(R.id.tv_name,mutiItemtem.getName());



    }
}
