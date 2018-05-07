package com.gosuncn.myeventbusdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

public class PublisherActivity extends AppCompatActivity {

    private static final String TAG = PublisherActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publisher);
    }

    /**
     * 在主线程中发布事件
     * @param view
     */
    public void onPublishEventOnMainThread(View view) {
        Log.d(TAG, "onPublishEventOnMainThread: ");
        MyEvent event = new MyEvent("主线程的消息");
        EventBus.getDefault().post(event);
        Toast.makeText(this,"主线程发布消息",Toast.LENGTH_SHORT).show();
    }

    /**
     * 在子线程中发送事件
     * @param view
     */
    public void onPublishEventOnBGThread(View view) {
        Log.d(TAG, "onPublishEventOnBGThread: ");
        Toast.makeText(this,"子线程发布消息",Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                MyEvent event = new MyEvent("后台线程的消息");
                EventBus.getDefault().post(event);
            }
        }).start();
    }
}
