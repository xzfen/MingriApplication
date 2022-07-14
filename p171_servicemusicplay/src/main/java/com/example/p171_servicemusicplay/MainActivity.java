package com.example.p171_servicemusicplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent=new Intent(MainActivity.this,MusicService.class);
        //获取“播放/停止”按钮
        ImageButton play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动和停止MusicService
                if(!MusicService.isplay){
                    startService(intent);//启动Service
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.play,null));
                }else{
                    stopService(intent);//停止Service
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.stop,null));
                }
            }
        });
    }

    @Override
    protected void onStart() {
        startService(new Intent(MainActivity.this,MusicService.class));//启动Service
        super.onStart();
    }
}