package com.example.p135_broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "fxz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取广播按钮
        Button button = findViewById(R.id.broadcast);
        //为按钮设置单击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyReceiver.class);
                intent.setAction("zuckerberg"); //为Intent添加动作zuckerberg
                sendBroadcast(intent); //发送广播
                Log.i(TAG, "MainActivity：成功发送扎克伯格的广播"+intent.getAction().toString());
            }
        });
    }
}