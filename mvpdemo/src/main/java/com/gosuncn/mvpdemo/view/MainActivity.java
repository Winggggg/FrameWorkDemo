package com.gosuncn.mvpdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gosuncn.mvpdemo.R;
import com.gosuncn.mvpdemo.bean.Book;
import com.gosuncn.mvpdemo.model.BookModel;
import com.gosuncn.mvpdemo.presenter.BookPresenter;

public class MainActivity extends AppCompatActivity implements BaseView{

    private BookPresenter mBookPresenter = new BookPresenter(this);
    private TextView tv_bookName;
    private TextView tv_bookAuthor;
    private TextView tv_bookDetail;
    private ProgressBar pb_loding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_bookName=findViewById(R.id.tv_bookName);
        tv_bookAuthor=findViewById(R.id.tv_bookAuthor);
        tv_bookDetail=findViewById(R.id.tv_bookDetail);
        pb_loding=findViewById(R.id.pb_loding);
        mBookPresenter.attach(this,new BookModel());

    }

    public  void getBookClick(View view){
        mBookPresenter.getBook();
    }

    @Override
    public void onLoadStart() {
        pb_loding.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoadError(String msg) {
        pb_loding.setVisibility(View.GONE);
        Toast.makeText(this,"请求失败："+msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadComplete(Book book) {
        pb_loding.setVisibility(View.GONE);
        tv_bookName.setText("书名:"+book.getBookName());
        tv_bookAuthor.setText("作者:"+book.getAuthor());
        tv_bookDetail.setText("书籍介绍："+book.getDetail());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBookPresenter.deatch();
    }
}
