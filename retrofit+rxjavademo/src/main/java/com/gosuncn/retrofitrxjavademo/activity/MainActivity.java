package com.gosuncn.retrofitrxjavademo.activity;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.gosuncn.retrofitrxjavademo.R;
import com.gosuncn.retrofitrxjavademo.adapter.RecyclerAdapter;
import com.gosuncn.retrofitrxjavademo.bean.Book;
import com.gosuncn.retrofitrxjavademo.bean.MSG;
import com.gosuncn.retrofitrxjavademo.databinding.ActivityMainBinding;
import com.gosuncn.retrofitrxjavademo.http.BaseObserver;
import com.gosuncn.retrofitrxjavademo.http.RetrofitService;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding mBinding;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        mBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

        /**
         * 获取书籍数据
         */
        public void getBookData(View view){
            RetrofitService.getInstance().getBookApi().getBook()
                    .compose(new ObservableTransformer<MSG<List<Book>>, MSG<List<Book>>>() {
                        @Override
                        public ObservableSource<MSG<List<Book>>> apply(Observable<MSG<List<Book>>> observable) {
                            return observable.subscribeOn(Schedulers.io())
                                            .doOnSubscribe(new Consumer<Disposable>() {
                                                @Override
                                                public void accept(Disposable disposable) throws Exception {
                                                    buildProgressDialog();
                                                }
                                            })
                                             .observeOn(AndroidSchedulers.mainThread());

                        }
                    }).subscribe(new BaseObserver<List<Book>>(MainActivity.this) {
                        @Override
                        protected void onHandleSuccess(Map<String, List<Book>> value) {

                            mBinding.recyclerView.setHasFixedSize(true);
                            mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            mBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
                            Log.e(TAG,"result=="+value.get("list"));

                            RecyclerAdapter adapter=new RecyclerAdapter(value.get("list"));
                            mBinding.recyclerView.setAdapter(adapter);

                            cancelProgressDialog();
                        }

                        @Override
                        protected void onHandleError(String msg) {
                            super.onHandleError(msg);
                            cancelProgressDialog();
                        }
            });
        }


    public void buildProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        progressDialog.setMessage("正在加载中....");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    public void cancelProgressDialog() {
        if (progressDialog != null)
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
    }

}
