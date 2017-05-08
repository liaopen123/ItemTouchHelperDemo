package com.example.pony.itemtouchhelperdemo.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by liaopenghui on 2017/5/8.
 */

public class MutiItem implements MultiItemEntity {

    public static final int POPTEXT = 1;
    public static final int CLASSCALMUSIC = 2;
    public static final int LIGHTLMUSIC = 3;
    private final int itemType;//类型值
    private final String name;


    public String getName() {
        return name;
    }

    /**
     *通过构造方法传入item Type值
     * @param name 名称

     */
    public MutiItem(String name) {
        this.name = name;

        switch (name){
            case "流行乐":
                this.itemType =POPTEXT;
                break;

            case "古典乐":
                this.itemType =CLASSCALMUSIC;
                break;

            case "轻音乐":
                this.itemType =LIGHTLMUSIC;
                break;
            default:
                this.itemType =LIGHTLMUSIC;
                break;
        }
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
