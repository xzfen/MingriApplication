package com.example.p143_animfairy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);//获取布局管理器
        //获取动画Drawable资源
        AnimationDrawable anim = (AnimationDrawable) linearLayout.getBackground();
        //为布局管理器添加单击事件
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag){
                    anim.start();//播放动画
                    flag=false;
                }else{
                    anim.stop();//停止动画
                    flag=true;
                }
            }
        });
    }
}