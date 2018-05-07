package com.gosuncn.mvpdemo.model;

import com.gosuncn.mvpdemo.bean.Book;
import com.gosuncn.mvpdemo.bean.MSG;
import com.gosuncn.mvpdemo.service.RetrofitService;

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
