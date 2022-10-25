package com.example.p7p1_servicedemo.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.example.p7p1_servicedemo.interfaces.ICommunication;

public class FirstService extends Service {
    private static final String TAG = "FirstService";

    private class InnerBinder extends Binder implements ICommunication {

        @Override
        public void callServiceInnerMethod() {
            sayHello();
        }
    }

    public FirstService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d(TAG, "onBind: ");
        return new InnerBinder();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    private void sayHello(){
        Toast.makeText(this, "Hello world!", Toast.LENGTH_SHORT).show();
    }
}