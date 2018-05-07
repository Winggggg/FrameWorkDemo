package com.gosuncn.mvvmdemo.model;

import com.gosuncn.mvvmdemo.bean.MSG;
import com.gosuncn.mvvmdemo.viewmodel.Book;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by weiye on 2018/5/5 0005.
 */

public interface BaseModel {

    Observable<MSG<List<Book>>> getBook();
}
