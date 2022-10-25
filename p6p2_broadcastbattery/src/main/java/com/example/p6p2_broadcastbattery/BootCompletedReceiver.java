package com.example.p6p2_broadcastbattery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @项目名称：MingriApplication
 * @包名：com.example.p6p2_broadcastbattery
 * @作者：FENG
 * @类名：BootCompletedReceiver
 * @创建时间：2022/8/2412:43
 * @描述：
 **/

//1.定义一个开机初始化完成的BroadcastReceiver类
public class BootCompletedReceiver extends BroadcastReceiver {
    private static final String TAG = "BootCompletedReceiver";

    public String getAction() {
        return mAction;
    }

    private String mAction;

    @Override
    public void onReceive(Context context, Intent intent) {
        mAction = intent.getAction();

    }
}
