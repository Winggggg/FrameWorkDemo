package com.gosuncn.mydatabindingdemo.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gosuncn.mydatabindingdemo.R;
import com.gosuncn.mydatabindingdemo.databinding.ActivityEventBinding;
import com.gosuncn.mydatabindingdemo.handler.EventHandler;
import com.gosuncn.mydatabindingdemo.task.Task;

public class EventActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_event);
        ActivityEventBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_event);

        binding.setHandler(new EventHandler(this));
        binding.setTask(new Task());
    }
}
