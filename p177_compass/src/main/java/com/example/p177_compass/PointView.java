package com.example.p177_compass;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class PointView  extends View implements SensorEventListener {
    private SensorManager sensorManager;//传感器管理器
    private Bitmap pointer=null;//定义指针的位图对象
    private float[] allValue;//磁场传感器的值

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        sensorManager= (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);//获取传感器管理器
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),sensorManager.SENSOR_DELAY_GAME);//为磁场传感器注册监听器
        pointer= BitmapFactory.decodeResource(super.getResources(),R.drawable.pointer);//指定要绘制的指针位图
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {  //当传感器的值改变是触发
        if(sensorEvent.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD){
            float value[] = sensorEvent.values; //获取磁场传感器三轴的输出信息
            allValue = value; // 保存输出信息
            super.postInvalidate();//刷新界面
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {   //当传感器精度改变时出发

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //根据X轴、Y轴磁场强度绘制指针
        if(allValue!=null){
            float x=allValue[0];//x轴磁场强度
            float y=allValue[1];//y轴磁场强度
            canvas.restore();//重置绘图对象
            canvas.translate(super.getWidth()/2,super.getHeight()/2);//设置旋转的中心点为屏幕的中心点
            // 判断y轴为0时的旋转角度
            if (y == 0 && x > 0) {
                canvas.rotate(90);    // 旋转角度为90度
            } else if (y == 0 && x < 0) {
                canvas.rotate(270);    // 旋转角度为270度
            } else {
                //通过三角函数atan()方法计算旋转角度
                if (y >= 0) {
                    canvas.rotate((float) Math.atan(x/y) * 90);
                } else {
                    canvas.rotate(180 + (float) Math.atan(x/y) * 90);
                }
            }
        }
        canvas.drawBitmap(this.pointer,-this.pointer.getWidth()/2,-this.pointer.getHeight()/2,new Paint());//绘制指针
    }
}
