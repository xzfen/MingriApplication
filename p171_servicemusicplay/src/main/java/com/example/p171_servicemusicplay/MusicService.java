package com.example.p171_servicemusicplay;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {
    static boolean isplay;//记录当前播放状态
    MediaPlayer player;//MediaPlayer对象

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        //创建MediaPlayer对象，并加载音乐资源文件
        player=MediaPlayer.create(this,R.raw.music);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!player.isPlaying()){
            player.start();//播放音乐文件
            isplay=player.isPlaying();//设置当前状态为正在播放音乐
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        player.stop();//停止播放
        isplay=player.isPlaying();//设置当前状态为停止播放音乐
        player.release();//释放资源
        super.onDestroy();
    }
}