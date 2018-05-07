package com.gosuncn.retrofitrxjavademo.http;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.gosuncn.retrofitrxjavademo.bean.MSG;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * BaseObserver
 * Created by jaycee on 2017/6/23.
 */
public abstract class BaseObserver<T> implements Observer<MSG<T>> {

    private static final String TAG = "BaseObserver";
    private Context mContext;

    protected BaseObserver(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(MSG<T> value) {
        if (value.getStatusCode()==100) {
            onHandleSuccess(value.getExtend());
        } else {
            onHandleError(value.getMessage());
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError:" + e.toString());
        onHandleError(e.getMessage());
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete");
    }

    protected abstract void onHandleSuccess(Map<String,T> value);

    protected void onHandleError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
