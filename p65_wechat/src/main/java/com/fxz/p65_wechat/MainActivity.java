package com.fxz.p65_wechat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 定义并初始化保存图片id的数组
        int[] imageid=new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03,
                R.drawable.img04,R.drawable.img05,R.drawable.img06,
                R.drawable.img07,R.drawable.img08,R.drawable.img09};
        // 定义并初始化保存列表项文字的数组
        String[] title=new String[]{"刘一","陈二","张三",
                "李四","王五","赵六",
                "孙七","周八","吴九"};
        // 创建一个list集合
        List<Map<String,Object>> listitem=new ArrayList<Map<String, Object>>();
        //通过for循环将图片id和列表项文字放到Map中，并添加到list集合中
        for (int i = 0; i < imageid.length; i++) {
            // 实例化Map对象
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("image",imageid[i]);
            map.put("title",title[i]);
            //将map对象添加到List集合中
            listitem.add(map);
        }
        //创建SimpleAdapter
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listitem,R.layout.main,
                new String[]{"title","image"},new int[]{R.id.title,R.id.image});
        // 获取列表视图
        ListView listView = findViewById(R.id.listView);
        //将适配器与ListView关联
        listView.setAdapter(simpleAdapter);
        //
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //定义Map对象,获取选择项的值
                Map<String,Object> map=(Map<String, Object>) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,map.get("title").toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}