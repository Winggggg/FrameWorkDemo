package com.gosuncn.mydatabindingdemo.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.gosuncn.mydatabindingdemo.R;
import com.gosuncn.mydatabindingdemo.TwoWayBinding;
import com.gosuncn.mydatabindingdemo.model.ObservableFieldContact;

public class TwoWayActivity extends Activity {
    private TwoWayBinding mBinding;
    private ObservableFieldContact mFieldContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_two_way);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_two_way);

        mFieldContact = new ObservableFieldContact("weiye","5555");
        mBinding.setContact(mFieldContact);
    }

    public void onClick(View view) {
        // 改变 Model，将同时改变 UI
        mFieldContact.mName.set("two-way");
    }
}
