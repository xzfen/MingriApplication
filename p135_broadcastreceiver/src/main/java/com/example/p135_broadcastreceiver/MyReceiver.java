package com.example.p135_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String ACTION_ZUCKERBERG="zuckerberg";
    private static final String TAG = "fxz";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(ACTION_ZUCKERBERG)){
            Toast.makeText(context, "MyReceiver收到：扎克伯格的广播", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "MyReceiver：成功收到扎克伯格的广播"+intent.getAction().toString());
        }
    }
}
