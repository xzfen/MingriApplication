package com.fxz.recyclerviewtest;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class RecyclerViewBaseAdapter extends RecyclerView.Adapter<RecyclerViewBaseAdapter.InnerHolder> {

    private final List<Contact> mData;

    //创建构造函数，把要展示的数据源传进来，并赋值给全局变量
    public RecyclerViewBaseAdapter(List<Contact> contactList){
        this.mData=contactList;
    }

    //创建InnerHolder实例，并把加载的列表项布局传入到构造函数中，将ViewHolder的实例返回
    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //将列表项布局加载到View中
        View view = getSubView(parent,viewType);
        //创建InnerHolder实例，并加载View
        final InnerHolder holder = new InnerHolder(view);
        //为子项布局设置点击事件
        holder.contactView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取用户点击的位置
                int position=holder.getAdapterPosition();
                //根据position获取点击的Contact实例
                Contact contact=mData.get(position);
                Toast.makeText(view.getContext(),"你点击了第"+position+"个条目:"+ contact.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        //返回InnerHolder实例
        return holder;
    }

    protected abstract View getSubView(@NonNull ViewGroup parent, int viewType);

    //用于对RecyclerView的子项数据进行赋值
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewBaseAdapter.InnerHolder holder, int position) {

        //通过position获取当前项的实例
        Contact contact = mData.get(position);
        //将数据设置到ViewHolder中
        holder.imageView.setImageResource(contact.getImageId());
        holder.nameView.setText(contact.getName());
        holder.numberView.setText(contact.getNumber());
    }

    //返回条目个数
    @Override
    public int getItemCount() {
        return mData.size();
    }

    //定义内部类InnerHolder继承自RecyclerView.ViewHolder
    public class InnerHolder extends RecyclerView.ViewHolder {
        View contactView;//保存子项布局
        ImageView imageView;
        TextView nameView;
        TextView numberView;
        //构造函数参数itemView就是子项布局View，通过findViewById获取布局中实例
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            //保存子项布局
            contactView=itemView;
            //保存子项布局的子项
            imageView = itemView.findViewById(R.id.imageView);
            nameView = itemView.findViewById(R.id.nameView);
            numberView = itemView.findViewById(R.id.numberView);

        }
    }
}
