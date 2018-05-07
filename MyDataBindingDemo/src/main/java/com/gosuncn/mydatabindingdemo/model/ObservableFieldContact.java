package com.gosuncn.mydatabindingdemo.model;

import android.databinding.ObservableField;

/**
 *ObservableFields model
 */
public class ObservableFieldContact  {

    public ObservableField<String> mName = new ObservableField<>();
    public ObservableField<String> mPhone = new ObservableField<>();

    public ObservableFieldContact(String name, String phone) {
        mName.set(name);
        mPhone.set(phone);
    }
}
