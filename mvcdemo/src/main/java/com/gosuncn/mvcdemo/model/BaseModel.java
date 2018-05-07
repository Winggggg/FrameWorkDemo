package com.gosuncn.mvcdemo.model;


import com.gosuncn.mvcdemo.bean.Book;
import com.gosuncn.mvcdemo.bean.MSG;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by weiye on 2018/5/5 0005.
 */

public interface BaseModel {

    Observable<MSG<List<Book>>> getBook();
}
