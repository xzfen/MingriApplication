package com.example.p6p8_customizebroadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SendOrderBroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_order_broadcast);
    }

    public void sendOrderBroadcast(View view) {
        Intent intent = new Intent();
        intent.setAction(Content.ACTION_SEND_ORDER_MSG);
        Bundle bundle = new Bundle();
        bundle.putCharSequence("content","我是被发送的内容");
        sendOrderedBroadcast(intent, null,null,null, Activity.RESULT_OK,null,bundle);
    }
}