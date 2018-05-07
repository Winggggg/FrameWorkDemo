package com.gosuncn.mydatabindingdemo.handler;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.gosuncn.mydatabindingdemo.task.Task;

/**
 * Created by wing on 2018/5/4 0004.
 * 事件处理
 */

public class EventHandler {
    private Context mContext;

    public EventHandler(Context context) {
        mContext = context;
    }

    public void onClickFriend(View view) {
        Toast.makeText(mContext, "onClickFriend", Toast.LENGTH_LONG).show();
    }

    public void onTaskClick(Task task) {
        task.run();
        Toast.makeText(mContext, "onTaskClick  监听方法绑定空参数", Toast.LENGTH_LONG).show();
    }

    public void onTaskClickWithParams(View view, Task task) {
        Toast.makeText(mContext, "onTaskClickWithParams  监听方法绑定有参数", Toast.LENGTH_LONG).show();
        task.run();
    }

    public void onCompletedChanged(Task task, boolean completed) {
        if(completed) {
            task.run();
        }
    }

}
