package com.gosuncn.mvpdemo.model;

import com.gosuncn.mvpdemo.bean.Book;
import com.gosuncn.mvpdemo.bean.MSG;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by weiye on 2018/5/5 0005.
 */

public interface BaseModel {

    Observable<MSG<List<Book>>> getBook();
}
