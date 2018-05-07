package com.gosuncn.mydatabindingdemo.handler;

import android.content.Context;

import com.gosuncn.mydatabindingdemo.R;

/**
 * Created by Administrator on 2018/5/4 0004.
 *
 */

public class ContextHandler {
    public String loadString(Context context) {
        return context.getResources().getString(R.string.string_from_context);
    }
}
