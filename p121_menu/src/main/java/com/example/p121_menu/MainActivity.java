package com.example.p121_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //第3步：重写onCreateOptionMenu()方法，添加一个选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //实例化MenuInflater对象
        MenuInflater menuInflater=new MenuInflater(this);
        //解析菜单资源
        menuInflater.inflate(R.menu.menu_test,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //重写onOptionsItemSelected()方法，指定各个菜单项被选择时，所应做的处理
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Intent intent_settings=new Intent(MainActivity.this,Settings.class);
                startActivity(intent_settings);
                break;
            case R.id.regard:
                Intent intent_regard=new Intent(MainActivity.this,Regard.class);
                startActivity(intent_regard);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}