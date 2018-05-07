package com.gosuncn.mvcdemo.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gosuncn.mvcdemo.R;
import com.gosuncn.mvcdemo.bean.Book;
import com.gosuncn.mvcdemo.bean.MSG;
import com.gosuncn.mvcdemo.model.BaseModel;
import com.gosuncn.mvcdemo.model.BookModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView tv_bookName;
    private TextView tv_bookAuthor;
    private TextView tv_bookDetail;
    private ProgressBar pb_loding;
    private BaseModel mModel=new BookModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_bookName=findViewById(R.id.tv_bookName);
        tv_bookAuthor=findViewById(R.id.tv_bookAuthor);
        tv_bookDetail=findViewById(R.id.tv_bookDetail);
        pb_loding=findViewById(R.id.pb_loding);
    }


    /**
     * 点击请求获取书籍数据
     * @param view
     */
    public void getBookClick(View view){
        mModel.getBook().compose(new ObservableTransformer<MSG<List<Book>>, MSG<List<Book>>>() {
            @Override
            public ObservableSource<MSG<List<Book>>> apply(Observable<MSG<List<Book>>> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                pb_loding.setVisibility(View.VISIBLE);
                            }
                        }).observeOn(AndroidSchedulers.mainThread());
            }
        }).subscribe(new Observer<MSG<List<Book>>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MSG<List<Book>> msg) {
                Log.e(TAG, "onNext"+"--"+msg.toString());
                Book book=msg.getExtend().get("list").get(0);
                tv_bookName.setText("书名:"+book.getBookName());
                tv_bookAuthor.setText("作者:"+book.getAuthor());
                tv_bookDetail.setText("书籍介绍："+book.getDetail());

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError");
                pb_loding.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this,"请求失败："+e.getMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete");
                pb_loding.setVisibility(View.GONE);
            }
        });
    }
}
