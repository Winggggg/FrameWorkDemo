package com.gosuncn.mydatabindingdemo.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gosuncn.mydatabindingdemo.R;
import com.gosuncn.mydatabindingdemo.databinding.ActivityCombineBinding;
import com.gosuncn.mydatabindingdemo.handler.ContextHandler;
import com.gosuncn.mydatabindingdemo.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombineActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combine);

        ActivityCombineBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_combine);

        User user = new User("weiye", "he", 22);
        binding.setUser(user);
        binding.setNum(1);

        // 容器类
        List<User> mUserList = new ArrayList<>();
        mUserList.add(user);
        mUserList.add(user);
        mUserList.add(user);
        binding.setUserList(mUserList);

        Map<String, String> map = new HashMap<>();
        map.put("1", "map1");
        map.put("2", "map2");
        map.put("3", "map3");
        binding.setMap(map);

        // Context
        ContextHandler handler = new ContextHandler();
        binding.setHandler(handler);

    }


}
