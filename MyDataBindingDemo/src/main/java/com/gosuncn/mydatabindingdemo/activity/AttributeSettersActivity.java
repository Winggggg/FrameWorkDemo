package com.gosuncn.mydatabindingdemo.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gosuncn.mydatabindingdemo.R;
import com.gosuncn.mydatabindingdemo.databinding.ActivityAttributeSettersBinding;
import com.gosuncn.mydatabindingdemo.model.User;

public class AttributeSettersActivity extends Activity {

    private ActivityAttributeSettersBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_attribute_setters);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_attribute_setters);

        User user = new User("weiye", "he", 22);
        mBinding.setUser(user);

    }
}
