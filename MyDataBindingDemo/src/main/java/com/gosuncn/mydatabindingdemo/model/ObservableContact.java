package com.gosuncn.mydatabindingdemo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.gosuncn.mydatabindingdemo.BR;

/**
 * Created by weiye on 2018/5/4 0004.
 * Observable 对象,简化开发
 */

public class ObservableContact extends BaseObservable {
    private String mName;
    private String mPhone;

    public ObservableContact(String name, String phone) {
        mName = name;
        mPhone = phone;
    }

    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
        notifyPropertyChanged(BR.phone);
    }
}
