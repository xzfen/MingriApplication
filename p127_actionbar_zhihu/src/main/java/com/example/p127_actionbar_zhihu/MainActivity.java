package com.example.p127_actionbar_zhihu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //解析菜单资源文件
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //实例化MenuInflater对象
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu); //解析菜单文件
        return super.onCreateOptionsMenu(menu);
    }
}