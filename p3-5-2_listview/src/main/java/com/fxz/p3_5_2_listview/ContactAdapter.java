package com.fxz.p3_5_2_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    private int resourceId;
    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        resourceId=resource;//获取子项布局ID
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Contact contact=getItem(position);//获取当前项的Contact实例
        //为Contact子项加载布局
        View view;
        ViewHolder viewHolder;
        if(convertView==null){//如果convertView为空，使用LayoutInflater加载布局
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            //创建ViewHolder实例
            viewHolder=new ViewHolder();
            //将控件的实例存放到viewHolder中
            viewHolder.contactImage = view.findViewById(R.id.imageView);
            viewHolder.contactName = view.findViewById(R.id.nameView);
            viewHolder.contactNumber = view.findViewById(R.id.numberView);
            view.setTag(viewHolder);//将viewHolder存储在View中
        }else{//否则直接对convertView进行重用
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();//重新获取viewHolder
        }
        //获取布局中子项
        //ImageView imageView = view.findViewById(R.id.imageView);
        //TextView textView = view.findViewById(R.id.textView);
        //设置显示的图片和文字
        viewHolder.contactImage.setImageResource(contact.getImageId());
        viewHolder.contactName.setText(contact.getName());
        viewHolder.contactNumber.setText(contact.getNumber());
        //返回这个子项布局
        return view;
    }
    //新增内部类ViewHolder，用于对控件的实例进行缓存
    class ViewHolder {
        ImageView contactImage;
        TextView contactName;
        TextView contactNumber;
    }
}
