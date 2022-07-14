package com.example.p166_message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    //定义图片数组
    private int[] images = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8};
    private Animation[] animation = new Animation[2];  //定义动画数组，为ViewFlipper指定切换动画
    private ViewFlipper flipper;//定义ViewFlipper
    final int FLAG_MSG=0x01;//消息代码
    private Message message;//声明消息对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /****************通过ViewFlipper组件播放广告图片*********************/
        //获取ViewFlipper
        flipper = findViewById(R.id.viewFlipper);
        for (int i = 0; i < images.length; i++) {//遍历图片数组中的图片
            ImageView imageView=new ImageView(this);//创建ImageView对象
            imageView.setImageResource(images[i]);//将遍历的图片保存在ImageView中
            flipper.addView(imageView);//加载图片
        }
        //初始化动画数组
        animation[0] = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left); //右侧平移进入动画
        animation[1] = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right); //左侧平移退出动画
        flipper.setInAnimation(animation[0]);   //为flipper设置图片进入动画效果
        flipper.setOutAnimation(animation[1]);  //为flipper设置图片退出动画效果
        /************开启广告轮播**************/
        message=Message.obtain();//获取Message对象
        message.what=FLAG_MSG;//设置消息代码
        handler.sendMessage(message);
    }
    /*****************创建Handler对象，实现3秒更新一次图片*************************/
    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what==FLAG_MSG){
                flipper.showNext();//切换到下一张图片
                message=handler.obtainMessage(FLAG_MSG);//获取Message
                handler.sendEmptyMessageDelayed(message.what,3000);
            }
        }
    };
}