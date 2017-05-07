package com.example.pony.itemtouchhelperdemo.callback;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by Pony on 2017/5/6.
 */

public class ItemDragAndSwipeCallback extends ItemTouchHelper.Callback {


    private final ItemTouchHelperAdapter adapter;

    public ItemDragAndSwipeCallback(ItemTouchHelperAdapter adapter) {

        this.adapter = adapter;
    }

    /**
     * 用于指定可以支持拖动和滑动的方向  使用helperItemTouchHelper.makeMovementFlags(int, int)来构造返回的flag。这里我们启用了上下左右两种方向。注：上下为拖动（drag），左右为滑动（swipe）。
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags,swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        adapter.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;//把默认的false改成true；
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        adapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    /**
     * 要支持长按 进入拖动的操作  需要返回为true
     * @return  长按 进入拖动的操作
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    public interface ItemTouchHelperAdapter {

        void onItemMove(int fromPosition, int toPosition);

        void onItemDismiss(int position);
    }

}
