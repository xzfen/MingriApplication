package com.example.p6p8_customizebroadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mContent;
    private Button mInform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        sendBroadcastInform();
    }

    private void sendBroadcastInform() {
        mInform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=mContent.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Content.ACTION_SEND_MSG);
                intent.putExtra(Content.KEY_CONTENT,content);
                sendBroadcast(intent);
            }
        });
    }

    private void initView() {
        mContent = findViewById(R.id.contents_tx);
        mInform = findViewById(R.id.inform_bt);
    }
}