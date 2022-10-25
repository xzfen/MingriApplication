package com.example.p6p8_customizebroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class HighLevelReceiver extends BroadcastReceiver {

    private static final String TAG = "HighLevelReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.d(TAG, "high level receive-->"+intent.getAction());
        //终止往下传达
        //abortBroadcast();
        Bundle bundle = getResultExtras(true);
        String content = bundle.getCharSequence("content").toString();
        Log.d(TAG, "content-->"+content);
        bundle.putCharSequence("content", "我是被修改的内容");
        setResultExtras(bundle);
    }
}