package com.example.p5p3_activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView info = findViewById(R.id.info);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String password = intent.getStringExtra("password");

        info.setText("用户名: "+name+"密码: "+password);

        User user = intent.getParcelableExtra("userkey");
        if(user!=null){
            Log.d(TAG, "name== "+user.getName());
            Log.d(TAG, "age== "+user.getAge());
            Log.d(TAG, "tall== "+user.getTall());
        }
    }
}