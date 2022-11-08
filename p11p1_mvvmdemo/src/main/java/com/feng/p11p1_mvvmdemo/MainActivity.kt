package com.feng.p11p1_mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {
        var loginBtn = findViewById<Button>(R.id.login_Btn)
        loginBtn.setOnClickListener {
            //进行登录
            toLogin()
        }
    }

    /**
    * 处理登录逻辑
    * */
    private fun toLogin() {
        val accountInputBox = findViewById<EditText>(R.id.account_edt)
        val passwordInputBox = findViewById<EditText>(R.id.password_edt)
        //做登录的逻辑处理
        val account = accountInputBox.text.toString()
        val password = passwordInputBox.text.toString()
        //检查账号格式是否正确
        if (TextUtils.isEmpty(account)) {
            //TODO:提示账号有问题
            return
        }
        //检查密码长度是否正确
        //给密码加盐
        //进行登录
    }
}