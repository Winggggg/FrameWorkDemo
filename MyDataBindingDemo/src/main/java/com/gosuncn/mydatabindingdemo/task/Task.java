package com.gosuncn.mydatabindingdemo.task;

import android.util.Log;

/**
 * Created by wing on 2018/5/4 0004.
 * 任务执行内容
 */

public class Task implements  Runnable{
    @Override
    public void run() {
        Log.i("weiye", "Task run");
    }

}
