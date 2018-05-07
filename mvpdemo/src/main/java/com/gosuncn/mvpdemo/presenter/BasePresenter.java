package com.gosuncn.mvpdemo.presenter;

import android.content.Context;
import android.util.Log;

import com.gosuncn.mvpdemo.model.BaseModel;
import com.gosuncn.mvpdemo.view.BaseView;

/**
 * Created by weiye on 2018/5/5 0005.
 */

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {

    private static final String TAG = BasePresenter.class.getSimpleName();
    protected  V mView;
    protected M mModel;
    protected Context mContext;

    public  BasePresenter(Context context){
        this.mContext=context;
    }

    public void attach(V mView,M mModel){
        if (this.mView==null){
            this.mView=mView;
        }
        if (this.mModel==null){
            this.mModel=mModel;
        }
    }


    public void deatch() {
        if (mView!=null){
            mView=null;
            Log.e(TAG, "unSubscribe: view null" );
        }

    }

    public abstract void getBook();

}
