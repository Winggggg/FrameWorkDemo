package com.gosuncn.mydatabindingdemo.util;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import com.gosuncn.mydatabindingdemo.model.FontFamily;

/**
 * Created by wing on 2018/5/4 0004.
 * 自定义参数
 */

public class Utils {

    @BindingAdapter({"font"})
    public static void setFont(TextView textView, String fontName) {
        textView.setTypeface(FontFamily.getInstance().getFont(fontName, textView.getContext()));
    }
}
