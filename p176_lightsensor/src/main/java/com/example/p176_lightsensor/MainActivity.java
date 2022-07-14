package com.example.p176_lightsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    //传感器输出信息编辑框
    private EditText textLight;
    //传感器管理器对象
    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textLight = findViewById(R.id.editLight);
        //获取SensorManager对象
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),SensorManager.SENSOR_DELAY_NORMAL);//为光线传感器注册监听器
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);//取消注册的监听器
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values=event.values;//获取传感器的值
        int sensorType = event.sensor.getType();//获取传感器类型
        StringBuilder stringBuilder=null;
        if(sensorType==Sensor.TYPE_LIGHT){
            stringBuilder=new StringBuilder();
            stringBuilder.append("光的强度值：");
            stringBuilder.append(values[0]);//添加获取的传感器的值
            textLight.setText(stringBuilder.toString());//显示到编辑框中
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}