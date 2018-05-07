package com.gosuncn.myeventbusdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class StickyActivity extends AppCompatActivity {

    private static final String TAG = StickyActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky);
        EventBus.getDefault().register(this);
    }

    @Subscribe( sticky = true, threadMode = ThreadMode.POSTING)
    public void onPostingEvent(MyStickyEvent event) {
        Log.d(TAG, "onPostingEvent:" + Thread.currentThread().getName());
        Toast.makeText(this,"收到"+event.msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
