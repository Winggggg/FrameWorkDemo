package com.gosuncn.retrofitrxjavademo.http;


import com.gosuncn.retrofitrxjavademo.bean.Book;
import com.gosuncn.retrofitrxjavademo.bean.MSG;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by weiye on 2018/5/5 0005.
 * 书籍请求api
 */

public interface BookApi {

//    @GET("borrowhistory")
//    Observable<MSG> getBook(
//            @Query("id") long id
//    );
    @GET("newbook")
    Observable<MSG<List<Book>>> getBook(

    );
}
