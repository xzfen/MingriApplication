package com.example.p148_musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private File file;
    private MediaPlayer mediaPlayer;
    private boolean isPause=false;//定义是否暂停状态
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏显示
        file=new File("/music.mp3");//获取要播放的音频文件
        if(file.exists()){
            mediaPlayer=MediaPlayer.create(this, Uri.parse(file.getAbsolutePath()));//创建MediaPlayer对象，并且装载要播放的音频
        }else {
            Toast.makeText(this,"播放的音频文件不存在",Toast.LENGTH_SHORT).show();
            return;
        }

        ImageButton btn_play = findViewById(R.id.btn_play);//获取播放/暂停按钮
        ImageButton btn_stop = findViewById(R.id.btn_stop);//获取停止按钮
        /*******播放/暂停按钮的单击事件监听器********/
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying() && !isPause){
                    mediaPlayer.pause();//暂停播放
                    isPause=true;//设置未暂停状态
                    //更换图标为播放
                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.play,null));
                }else {
                    mediaPlayer.start();//继续播放
                    isPause=false;//设置为播放状态
                    //更换图标为暂停
                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.pause,null));

                }
            }
        });
        /*******停止按钮的单击事件监听器********/
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();//停止播放
                btn_play.setImageDrawable(getResources().getDrawable(R.drawable.play,null));
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                play();//重新播放功能
            }
        });
    }
    private void play() {
        mediaPlayer.reset();//重置MediaPlayer
        try {
            mediaPlayer.setDataSource(file.getAbsolutePath());
            mediaPlayer.prepare();//预加载视频
            mediaPlayer.start();//播放音频
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();//停止播放
        }
        mediaPlayer.release();//释放资源
        super.onDestroy();
    }
}