package com.example.p156_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //定义后台账号和密码
    private String name = "fxz", pwd = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取编辑框用户名和密码
        EditText username_EditText = findViewById(R.id.username);
        EditText password_EditText = findViewById(R.id.password);
        //获取登录按键
        ImageButton login = findViewById(R.id.login);
        //获取Shared Preferences对象
        final SharedPreferences sharedPreferences = getSharedPreferences("qqAutoLogin", MODE_PRIVATE);
        /**********实现自动登录功能************/
        //获取账号信息
        String username = sharedPreferences.getString("username", null);
        String password = sharedPreferences.getString("password", null);
        //判断用户名和密码是否为空
        if (username != null && password != null) {
            //如果用户名和密码相同，实现自动登录
            if (username.equals(name) && password.equals(pwd)) {
                //通过Intent跳转登录
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                //启动跳转界面
                startActivity(intent);
            }
        } else {
            /**********实现手动登录并储存账号和密码************/
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //获取输入的账号和密码
                    String local_username=username_EditText.getText().toString();
                    String local_password=password_EditText.getText().toString();
                    //获取Editor对象
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    if(local_username.equals(name) && local_password.equals(pwd)){
                        //这里保存账号和密码并提交有些多余
                        editor.putString("username",local_username);
                        editor.putString("password",local_password);
                        //提交信息
                        editor.commit();
                        //通过Intent跳转登录
                        Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                        //启动跳转界面
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "已保存账号和密码", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "账号和密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}