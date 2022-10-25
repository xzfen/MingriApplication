package com.example.p7p1_servicedemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.example.p7p1_servicedemo.interfaces.ICommunication;
import com.example.p7p1_servicedemo.services.FirstService;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private Boolean mIsServiceBinded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate--");
    }

    public void stopService(View view) {
        Intent intent=new Intent();
        intent.setClass(this, FirstService.class);
        stopService(intent);
    }

    public void startService(View view) {
        Intent intent=new Intent();
        intent.setClass(this,FirstService.class);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy--");
    }

    public void callServiceMethod(View view){
        Log.d(TAG, "callServiceMethod: ");
        if (mRemoteBinder!=null) {
            mRemoteBinder.callServiceInnerMethod();
        }
    }
    public void bindService(View view) {
        Intent intent=new Intent();
        intent.setClass(this,FirstService.class);
        mIsServiceBinded = bindService(intent,mServiceConnection,BIND_AUTO_CREATE);
    }

    private ICommunication mRemoteBinder;
    ServiceConnection mServiceConnection=new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: ");
            mRemoteBinder = (ICommunication) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: ");
            mRemoteBinder=null;
        }
    };

    public void unbindService(View view) {
        if (mServiceConnection!=null&& mIsServiceBinded) {
            unbindService(mServiceConnection);
            mIsServiceBinded=false;
        }
    }
}