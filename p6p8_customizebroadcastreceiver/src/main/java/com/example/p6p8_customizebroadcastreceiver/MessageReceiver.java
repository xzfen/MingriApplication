package com.example.p6p8_customizebroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MessageReceiver extends BroadcastReceiver {

    private static final String TAG = "MessageReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String action = intent.getAction();
        Log.d(TAG, "action is -->" + action);
        String content = intent.getStringExtra(Content.KEY_CONTENT);
        Log.d(TAG, "content is -->" + content);
    }
}