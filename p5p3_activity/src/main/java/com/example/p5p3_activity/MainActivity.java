package com.example.p5p3_activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
/*
* 为什么要有两种意图：
* 显示意图一般用于应用内组件跳转
* 隐示意图的话，一般用于第三方应用之间的跳转
* */
public class MainActivity extends AppCompatActivity {

    private Button mLogin;
    private TextView mPassword;
    private TextView mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String nameText = mName.getText().toString().trim();
        if (TextUtils.isEmpty(nameText)) {
            Toast.makeText(this,"输入的账号为空！",Toast.LENGTH_SHORT).show();
            return;
        }

        String passwordText = mPassword.getText().toString().trim();
        if (TextUtils.isEmpty(passwordText)) {
            Toast.makeText(this,"输入的密码为空！",Toast.LENGTH_SHORT).show();
            return;
        }

        /*
        * 这部分是显示意图跳转另外一个Activity
        * */
        /*Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("name",nameText);
        intent.putExtra("password",passwordText);
        startActivity(intent);*/
        /*
        * 这部分是隐示意图跳转到另一个Activity
        * */
        /*Intent intent=new Intent();
        intent.setAction("com.example.LOGIN_INFO");
        //intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("name",nameText);
        intent.putExtra("password",passwordText);
        startActivity(intent);*/

        /*
         * 显式意图跳转到另一个应用
         *
         * */
        /*Intent intent = new Intent();
        intent.setClassName("com.android.browser","com.android.browser.BrowserActivity");
        //intent.setComponent(new ComponentName("com.android.browser","com.android.browser.BrowserActivity"));
        startActivity(intent);*/
    }

    private void initView() {
        mName = findViewById(R.id.name);
        mPassword = findViewById(R.id.password);
        mLogin = findViewById(R.id.login);
    }

    public void deliver_object(View v){
        /*
        * 传递对象
        * 1.先实现界面跳转
        * 2.创建对象，实现Parcelable接口
        * 3.用putExtra的方式加入Intent对象
        * 4.在第二个界面用key来获取传递的对象
        * */
        Intent intent = new Intent(this, SecondActivity.class);
        User user = new User();
        user.setName("BillGates");
        user.setAge(60);
        user.setTall(170.1f);

        //String value = null;
        //Bitmap bitmap = null;

        intent.putExtra("userkey",user);
        //intent.putExtra("valuekey", value);
        //intent.putExtra("bitmapkey", bitmap);

        startActivity(intent);
    }

    //隐式意图跳转到实现拨打电话功能
    public void deliver_call(View v){
        Intent intent = new Intent();
        Uri uri = Uri.parse("tel:10086");
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(uri);
        startActivity(intent);
    }

    //隐式意图跳转到实现发送短信功能
    public void deliver_smsto(View v){
        Intent intent = new Intent();
        Uri uri = Uri.parse("smsto:10086");
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(uri);
        intent.putExtra("sms_body", "Hello");

        startActivity(intent);
    }

    //隐式意图跳转到浏览器
    public void deliver_sohu(View v){
        Intent intent = new Intent();
        Uri uri = Uri.parse("http://www.sohu.com");
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(uri);
        //Intent intent = new Intent(Intent.ACTION_VIEW,uri);

        startActivity(intent);
    }
}