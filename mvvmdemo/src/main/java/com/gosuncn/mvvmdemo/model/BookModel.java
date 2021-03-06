package com.gosuncn.mvvmdemo.model;


import com.gosuncn.mvvmdemo.bean.MSG;
import com.gosuncn.mvvmdemo.service.RetrofitService;
import com.gosuncn.mvvmdemo.viewmodel.Book;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by weiye on 2018/5/5 0005.
 */

public class BookModel implements BaseModel{

    @Override
    public Observable<MSG<List<Book>>> getBook() {
        return RetrofitService.getInstance()
                .getBookApi()
                .getBook();

    }
}
