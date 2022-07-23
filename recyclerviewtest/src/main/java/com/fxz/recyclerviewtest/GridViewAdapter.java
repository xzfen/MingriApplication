package com.fxz.recyclerviewtest;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//新建ContactViewAdapter类继承自RecyclerView.Adapter，并将泛型指定为GridViewAdapter.InnerHolder
public class GridViewAdapter extends RecyclerViewBaseAdapter {

    //创建构造函数，把要展示的数据源传进来，并赋值给全局变量
    public GridViewAdapter(List<Contact> contactList){
        super(contactList);
    }

    @Override
    protected View getSubView(@NonNull ViewGroup parent, int viewType) {
        //将列表项布局加载到View中
        View view = View.inflate(parent.getContext(), R.layout.grid_view_item, null);
        return view;
    }
}
