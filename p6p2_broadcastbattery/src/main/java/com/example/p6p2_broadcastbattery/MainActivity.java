package com.example.p6p2_broadcastbattery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mBatteryLevel;
    private BatteryLevelReceiver mBatteryLevelReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initBatteryChangeReceiver();

        BootCompletedReceiver bootCompletedReceiver= new BootCompletedReceiver();
        String action = bootCompletedReceiver.getAction();
        Log.d(TAG, "开机完成： "+ action);
        Toast.makeText(this, "开机完成", Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mBatteryLevel = findViewById(R.id.batteryLevel_tx);
    }

    private void initBatteryChangeReceiver() {
        //2.创建IntentFilter对象
        IntentFilter intentFilter = new IntentFilter();
        //3.设置IntentFilter的action：接收的频道为电量变化
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        //4.定义电量变化接收者对象
        mBatteryLevelReceiver = new BatteryLevelReceiver();
        //5.注册广播
        this.registerReceiver(mBatteryLevelReceiver,intentFilter);
    }

    //1.定义一个电量变化广播接收者类，继承自BroadcastReceiver
    private class BatteryLevelReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action){
                case Intent.ACTION_BATTERY_CHANGED:
                    int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                    if (mBatteryLevel!=null) {
                        mBatteryLevel.setText("当前电量："+level);
                    }
                    break;
                case Intent.ACTION_POWER_CONNECTED:
                    Log.d(TAG, "USB线连接上了");
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    Log.d(TAG, "USB线断开了");
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBatteryLevelReceiver!=null) {
            this.unregisterReceiver(mBatteryLevelReceiver);
        }
    }
}