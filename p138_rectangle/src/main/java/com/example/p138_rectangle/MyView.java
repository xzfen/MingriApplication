package com.example.p138_rectangle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {


    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();//定义了一个默认的画笔
        paint.setColor(0xFFFF6600);//设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充方式
        canvas.drawRect(10,10,280,150,paint);
    }
}
