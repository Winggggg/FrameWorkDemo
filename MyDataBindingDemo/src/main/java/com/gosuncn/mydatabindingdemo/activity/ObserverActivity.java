package com.gosuncn.mydatabindingdemo.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.gosuncn.mydatabindingdemo.R;
import com.gosuncn.mydatabindingdemo.databinding.ActivityObserverBinding;
import com.gosuncn.mydatabindingdemo.model.ObservableContact;

public class ObserverActivity extends Activity {


    private ActivityObserverBinding mBinding;
    private ObservableContact mObservableContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_observer);

        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_observer);

        mObservableContact = new ObservableContact("wing","11111111");
        mBinding.setContact(mObservableContact);

    }

    public void onClick(View view) {
        mObservableContact.setName("weiye");
        mObservableContact.setPhone("555555555");
    }
}
