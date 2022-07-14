package com.example.p140_drawdialogue;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Environment;
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
        //绘制对白
        /*Paint paint=new Paint();//创建画笔
        paint.setColor(0xFF000000);//设置画笔颜色
        paint.setAntiAlias(true);//采用抗锯齿功能
        paint.setTextAlign(Paint.Align.LEFT);//设置文字对其方式
        paint.setTextSize(18);//设置文字大小
        canvas.drawText("你想和我一起",175,160,paint);//绘制文字
        canvas.drawText("去探险么？",175,175,paint);

        canvas.drawText("不，我不想去！",245,45,paint);*/
        //绘制图片
        String path= Environment.getExternalStorageDirectory()+"/DCIM/Camera/20210817105316.jpeg";//获取文件的路径
        Bitmap bitmap= BitmapFactory.decodeFile(path);
        Paint paint=new Paint();//定义画笔
        //绘制图片
        canvas.drawBitmap(bitmap,0,0,paint);
    }
}
