package com.gosuncn.mydatabindingdemo.handler;

import android.content.Context;
import android.content.Intent;

import com.gosuncn.mydatabindingdemo.model.RecyclerItem;

/**
 * Created by Administrator on 2018/5/4 0004.
 * 负责处理业务逻辑
 */

public class Presenter {
    /**
     * 页面跳转逻辑
     * @param context
     * @param recyclerItem
     */
    public void onTypeClick(Context context, RecyclerItem recyclerItem) {
        Intent intent = new Intent(recyclerItem.getAction());
        context.startActivity(intent);
    }
}
