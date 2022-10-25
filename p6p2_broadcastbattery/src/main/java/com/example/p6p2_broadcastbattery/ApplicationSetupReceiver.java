package com.example.p6p2_broadcastbattery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ApplicationSetupReceiver extends BroadcastReceiver {

    private static final String TAG = "ApplicationSetupReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        String action = intent.getAction();
        if (Intent.ACTION_PACKAGE_ADDED.equals(action)) {
            //应用安装
            Log.d(TAG, "应用安装，相关信息是： "+intent.getData());
        }else if(Intent.ACTION_PACKAGE_REMOVED.equals(action)){
            //应用卸载
            Log.d(TAG, "应用卸载，相关信息是： "+intent.getData());
        }
        // an Intent broadcast.

    }
}