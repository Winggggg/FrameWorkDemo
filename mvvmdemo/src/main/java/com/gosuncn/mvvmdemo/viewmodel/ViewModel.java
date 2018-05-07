package com.gosuncn.mvvmdemo.viewmodel;

import android.databinding.ObservableField;

/**
 * Created by weiye on 2018/5/5 0005.
 */

public class ViewModel {
    public ObservableField<Boolean> isStartRequest = new ObservableField<>();

    public ViewModel(boolean mIsStartRequest) {
        isStartRequest.set(mIsStartRequest);
    }
}
