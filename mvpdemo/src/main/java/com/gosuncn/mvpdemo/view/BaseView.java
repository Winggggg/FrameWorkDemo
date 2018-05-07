package com.gosuncn.mvpdemo.view;

import com.gosuncn.mvpdemo.bean.Book;

/**
 * Created by weiye on 2018/5/5 0005.
 */

public interface BaseView {


    void onLoadStart();

    void onLoadError(String msg);

    void onLoadComplete(Book book);
}
