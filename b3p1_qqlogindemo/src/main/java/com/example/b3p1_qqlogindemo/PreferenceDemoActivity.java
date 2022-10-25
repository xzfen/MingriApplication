package com.example.b3p1_qqlogindemo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.Nullable;

public class PreferenceDemoActivity extends Activity implements CompoundButton.OnCheckedChangeListener {
    private static final String TAG = "fengxz";
    private Switch mIsAllow;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "PreferenceDemoActivity:onCreate: ");
        setContentView(R.layout.activity_preference_demo);
        //找到控件
        mIsAllow = findViewById(R.id.is_allow_unknown_sources_switch);
        mIsAllow.setOnCheckedChangeListener(this);
        //1.通过Context类中的getSharedPreferences得到一个SharedPreferences对象
        mSharedPreferences = this.getSharedPreferences("settings_info", MODE_PRIVATE);
        //获取文件的默认值
        boolean state = mSharedPreferences.getBoolean("state", false);
        //设置回显
        mIsAllow.setChecked(state);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //对数据进行保存
        Log.d(TAG, "当前状态为： " + isChecked);
        //2.调用SharedPreferences对象的edit()方法获取SharedPreferences.Editor对象
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        //3.添加数据
        editor.putBoolean("state",isChecked);
        //4.提交数据
        editor.apply();

    }
}
