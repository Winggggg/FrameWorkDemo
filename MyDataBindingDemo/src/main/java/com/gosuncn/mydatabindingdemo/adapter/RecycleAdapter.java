package com.gosuncn.mydatabindingdemo.adapter;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gosuncn.mydatabindingdemo.BR;
import com.gosuncn.mydatabindingdemo.R;
import com.gosuncn.mydatabindingdemo.databinding.ExampleItemBinding;
import com.gosuncn.mydatabindingdemo.handler.Presenter;
import com.gosuncn.mydatabindingdemo.model.RecyclerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/4 0004.
 * 示例列表适配器
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.BindingHolder> {
    private static final String ACTION_PRE = "gosuncn.databinding.action.";

    private String[] mType = new String[]{
            "Combine",
            "Observer",
            "ObserverField",
            "ObserverCollection",
            "Event",
            "AttributeSetters",
            "Converters",
            "TwoWay"
    };

    private List<RecyclerItem> mRecyclerItemList = new ArrayList<>();

    public RecycleAdapter() {
        //添加数据
        mRecyclerItemList.clear();
        for(String str : mType) {
            RecyclerItem mRecyclerItem = new RecyclerItem(str, ACTION_PRE + str);
            mRecyclerItemList.add(mRecyclerItem);
        }
    }


    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ExampleItemBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.example_item, parent, false);

        Presenter presenter = new Presenter();
        binding.setMpresenter(presenter);

        BindingHolder holder = new BindingHolder(binding.getRoot());
        holder.setBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
       //动态绑定
        holder.getBinding().setVariable(BR.mitem, mRecyclerItemList.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mRecyclerItemList.size();
    }


    public class BindingHolder extends RecyclerView.ViewHolder {
        private ExampleItemBinding binding;

        public BindingHolder(View itemView) {
            super(itemView);
        }

        public ExampleItemBinding getBinding() {
            return binding;
        }

        public void setBinding(ExampleItemBinding binding) {
            this.binding = binding;
        }
    }
}
