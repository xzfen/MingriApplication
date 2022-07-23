package com.fxz.p3_5_2_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    // 创建一个list集合
    List<Contact> listitem=new ArrayList<Contact>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化Contact数据
        initContacts();
        //创建ContactAdapter实例
        ContactAdapter adapter=new ContactAdapter(this,R.layout.contact_item,listitem);
        //获取ListView
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        //为listView注册监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact =(Contact) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,contact.getName()+contact.getNumber(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    //初始化Contact数据函数
    private void initContacts(){
        // 定义并初始化保存图片id的数组
        int[] imageid=new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03,
                R.drawable.img04,R.drawable.img05,R.drawable.img06,
                R.drawable.img07,R.drawable.img08,R.drawable.img09,
                R.drawable.img07,R.drawable.img08,R.drawable.img09};
        // 定义并初始化保存列表项名字和号码的数组
        String[] names=new String[]{"刘一","陈二","张三",
                "李四","王五","赵六",
                "孙七","周八","吴九",
                "周十","郑十一","冯十二"};
        String[] numbers=new String[]{"志当存高远","有志者事竟成","欲穷千里目",
                "更上一层楼","活着就是为了改变世界，难道还有其他原因么？","领袖和跟风者的区别就在于创新",
                "310","320","330",
                "410","420","430"};
        //通过for循环将图片id和列表项文字放到Contact对象中，并添加到list集合中
        for (int i = 0; i < imageid.length; i++) {
            // 实例化Contact对象
            Contact contact=new Contact(names[i], numbers[i], imageid[i]);
            //将Contact对象添加到List集合中
            listitem.add(contact);
        }
    }
}