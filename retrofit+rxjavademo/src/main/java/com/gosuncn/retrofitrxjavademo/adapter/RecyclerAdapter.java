package com.gosuncn.retrofitrxjavademo.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gosuncn.retrofitrxjavademo.R;
import com.gosuncn.retrofitrxjavademo.bean.Book;
import com.gosuncn.retrofitrxjavademo.databinding.BookItemBinding;

import java.util.List;


/**
 * Created by weiye on 2018/5/5 0005.
 * 书籍列表适配器
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.BindingHolder>{

    private List<Book> mDatas;

    public RecyclerAdapter(List<Book> mDatas) {
        this.mDatas = mDatas;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       BookItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.book_item,parent,false);
       BindingHolder bindingHolder=new BindingHolder(binding.getRoot());
       bindingHolder.setBookItemBinding(binding);
       return bindingHolder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
//        holder.getBookItemBinding().setVariable(BR.book,mDatas.get(position));
        holder.getBookItemBinding().setBook(mDatas.get(position));
//        holder.getBookItemBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    public class BindingHolder extends RecyclerView.ViewHolder {
        private BookItemBinding bookItemBinding;

        public BindingHolder(View itemView) {
            super(itemView);
        }

        public BookItemBinding getBookItemBinding() {
            return bookItemBinding;
        }

        public void setBookItemBinding(BookItemBinding bookItemBinding) {
            this.bookItemBinding = bookItemBinding;
        }
    }
}
