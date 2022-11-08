package com.feng.p9p4_androidnetwork.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.feng.p9p4_androidnetwork.R;
import com.feng.p9p4_androidnetwork.domain.TextItems;

import java.util.ArrayList;
import java.util.List;

/**
 * @项目名称：MingriApplication
 * @包名：com.feng.p9p4_androidnetwork.adapter
 * @作者：FENG
 * @类名：ItemListAdapter
 * @创建时间：2022/11/712:56
 * @描述：
 **/
public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.InnerHolder> {
    private List<TextItems.DataBean> mData = new ArrayList<>();
    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false);
        InnerHolder holder = new InnerHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        View itemView = holder.itemView;
        TextView title = itemView.findViewById(R.id.item_title);
        TextItems.DataBean dataBean = mData.get(position);
        title.setText(dataBean.getTitle());
        ImageView cover = itemView.findViewById(R.id.item_iv);
        //加载图片
        //Glide.with(itemView.getContext()).load("http://10.0.2.2:9102" + mData.get(position).getCover).into(cover);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(TextItems textItems) {
        mData.clear();
        mData.addAll(textItems.getData());
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
