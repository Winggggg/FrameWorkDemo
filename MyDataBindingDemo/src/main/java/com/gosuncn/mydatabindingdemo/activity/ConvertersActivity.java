package com.gosuncn.mydatabindingdemo.activity;

import android.app.Activity;
import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.gosuncn.mydatabindingdemo.R;
import com.gosuncn.mydatabindingdemo.databinding.ActivityConvertersBinding;
import com.gosuncn.mydatabindingdemo.model.User;

import java.util.ArrayList;
import java.util.List;

public class ConvertersActivity extends Activity {

    private ObservableBoolean mIsError = new ObservableBoolean();

    ActivityConvertersBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_converters);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_converters);

        List<User> usrList = new ArrayList<>();
        usrList.add(new User("weiye", "he", 22));
        mBinding.setList(usrList);

        mIsError.set(true);
        mBinding.setIsError(mIsError);
    }

    public void onToggle(View view) {
        mIsError.set(!mIsError.get());
    }

    // 方法名可自定义，只需关心参数 User
    @BindingConversion
    public static String convertUserToCharSequence(User user) {
        return user.getFullName();
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }


}
