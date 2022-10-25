package com.example.p6p8_customizebroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class LowLevelReceiver extends BroadcastReceiver {

    private static final String TAG = "LowLevelReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.d(TAG, "low level receive-->"+intent.getAction());
        Bundle bundle = getResultExtras(true);
        String content = bundle.getCharSequence("content").toString();
        Log.d(TAG, "content-->"+content);
    }
}