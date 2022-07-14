package com.example.p126_actionbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取ActionBar对象
        ActionBar actionBar=getSupportActionBar();
        //获取Button对象
        Button displayButton = findViewById(R.id.display_button);
        Button hideButton = findViewById(R.id.hide_button);
        //单击事件监听器
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionBar.show(); //显示Action Bar
            }
        });
        hideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionBar.hide(); //隐藏Action Bar
            }
        });
    }
}