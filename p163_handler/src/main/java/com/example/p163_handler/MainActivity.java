package com.example.p163_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取文本框组件
        final TextView textView = findViewById(R.id.textView);
        //获取按钮组件
        Button next = findViewById(R.id.next);
        //创建一个消息对象
        Handler handler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if(msg.what==0x123){
                    textView.setText("你今天的努力，是幸运的伏笔；当下的付出，是明日的花开");
                }
            }
        };

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建新线程
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //发送空消息
                        handler.sendEmptyMessage(0x123);
                        //textView.setText("你今天的努力，是幸运的伏笔；当下的付出，是明日的花开");
                    }
                });
                //开启线程
                thread.start();
            }
        });
    }
}