package com.gosuncn.mydatabindingdemo.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.gosuncn.mydatabindingdemo.R;
import com.gosuncn.mydatabindingdemo.databinding.ActivityObserverFieldBinding;
import com.gosuncn.mydatabindingdemo.model.ObservableFieldContact;

public class ObserverFieldActivity extends Activity {
    ActivityObserverFieldBinding mBinding;
    private ObservableFieldContact mObservableFieldContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_observer_field);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_observer_field);

        mObservableFieldContact = new ObservableFieldContact("wing","11111");
        mBinding.setContact(mObservableFieldContact);

    }

    public void onClick(View view) {
        mObservableFieldContact.mName.set("weiye");
        mObservableFieldContact.mPhone.set("55555555555");
    }
}
