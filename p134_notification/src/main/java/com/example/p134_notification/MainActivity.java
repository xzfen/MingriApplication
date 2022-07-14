package com.example.p134_notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取Button对象
        Button send = findViewById(R.id.send);
        Button cancel = findViewById(R.id.cancel);
        //设置点击事件处理
        send.setOnClickListener(listener);
        cancel.setOnClickListener(listener);

    }
    /*
        这部分代码参考了【2021最新版】Android studio安装教程+Android（安卓）零基础教程视频的
        P16 2.控件6_Notification
        和Android开发从入门到精通（项目案例版）
        P78 10使用Fragment实例--微信界面Tab标签切换中的
        创建单击事件监听器
    */
    View.OnClickListener listener = new View.OnClickListener() {
        private NotificationManager manager;
        private Notification notification;
        private int NOTIFYID=0X01;
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.send:
                    //创建一个NotificationManager对象
                    manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    //如果是8.0以上，需要创建通知渠道
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                        NotificationChannel channel = new NotificationChannel("fengxz", "测试通知",
                                NotificationManager.IMPORTANCE_HIGH);
                        manager.createNotificationChannel(channel);
                    }

                    //创建一个启动详细页面的Intent对象
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0x0123,intent,0);

                    //创建一个notification通知对象
                    notification = new NotificationCompat.Builder(MainActivity.this, "fengxz")
                            .setContentTitle("奖励百万红包！！！") //设置通知标题
                            .setContentText("点击查看详情！") //设置通知内容
                            .setSmallIcon(R.drawable.bazinga) //设置通知图标
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.bazinga)) //设置大图标
                            .setAutoCancel(true) //设置通知打开后，自动消失
                            .setWhen(System.currentTimeMillis()) //设置发送时间
                            .setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_VIBRATE) //设置通知的声音和震动
                            .setContentIntent(pendingIntent) //设置通知栏点击跳转
                            .build();
                    //发送通知
                    manager.notify(NOTIFYID,notification);
                    break;
                case R.id.cancel:
                    //取消通知
                    manager.cancel(NOTIFYID);
                    break;
                default:
                    break;
            }
        }
    };
}