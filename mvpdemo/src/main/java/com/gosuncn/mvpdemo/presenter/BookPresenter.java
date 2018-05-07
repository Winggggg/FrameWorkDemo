package com.gosuncn.mvpdemo.presenter;

import android.content.Context;
import android.util.Log;

import com.gosuncn.mvpdemo.bean.Book;
import com.gosuncn.mvpdemo.bean.MSG;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by weiye on 2018/5/5 0005.
 */

public class BookPresenter extends BasePresenter {

    private static final String TAG = BookPresenter.class.getSimpleName();

    public BookPresenter(Context context) {
        super(context);
    }

    @Override
    public void getBook() {
        mModel.getBook()
                .compose(new ObservableTransformer<MSG<List<Book>>, MSG<List<Book>>>() {
                    @Override
                    public ObservableSource<MSG<List<Book>>> apply(Observable<MSG<List<Book>>> observable) {
                        return observable
                                .subscribeOn(Schedulers.io())
                                .doOnSubscribe(new Consumer<Disposable>() {
                                    @Override
                                    public void accept(Disposable disposable) throws Exception {
                                        mView.onLoadStart();
                                    }
                                })
                                .observeOn(AndroidSchedulers.mainThread());
                    }
                })
                .subscribe(new Observer<MSG<List<Book>>>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MSG<List<Book>> msg) {
                        Log.e(TAG, "onNext"+"--"+msg.toString());
                        mView.onLoadComplete(msg.getExtend().get("list").get(0));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError");
                        mView.onLoadError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete");
                    }
                });
    }
}
