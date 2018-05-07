package com.gosuncn.mvvmdemo.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.gosuncn.mvvmdemo.R;
import com.gosuncn.mvvmdemo.bean.MSG;
import com.gosuncn.mvvmdemo.databinding.ActivityMainBinding;
import com.gosuncn.mvvmdemo.model.BaseModel;
import com.gosuncn.mvvmdemo.model.BookModel;
import com.gosuncn.mvvmdemo.viewmodel.Book;
import com.gosuncn.mvvmdemo.viewmodel.ViewModel;

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
    private ActivityMainBinding binding;
    private BaseModel mModel=new BookModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);

    }


    /***
     * 点击请求获取书籍数据
     * @param view
     */
    public  void getBookClick(View view){
        mModel.getBook().compose(new ObservableTransformer<MSG<List<Book>>, MSG<List<Book>>>() {
            @Override
            public ObservableSource<MSG<List<Book>>> apply(Observable<MSG<List<Book>>> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                binding.setViewModel(new ViewModel(true));
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
                binding.setBook(book);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError");
                binding.setViewModel(new ViewModel(false));
                Toast.makeText(MainActivity.this,"请求失败："+e.getMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete");
                binding.setViewModel(new ViewModel(false));
            }
        });
    }
}
