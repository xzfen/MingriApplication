package com.example.p157_filestoragememo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    //定义保存数据的数组
    byte[] buffer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取用于填写备忘录的编辑框
        EditText editText = findViewById(R.id.editText);
        //获取保存按钮
        Button btnSave = findViewById(R.id.btnSave);
        //获取取消按钮
        Button btnRead = findViewById(R.id.btnRead);
        /**********************保存填写的备忘信息**********************/
        //保存按钮按键事件监听器
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //声明文件输出流
                FileOutputStream fileOutputStream=null;
                //获取输入的备忘信息
                String text=editText.getText().toString();
                try {
                    //获得文件输出流对象
                    fileOutputStream=openFileOutput("p157_memo",MODE_PRIVATE);
                    //输出流的write方法以字节单位向目的地写数据
                    fileOutputStream.write(text.getBytes());

                    //清除缓存
                    fileOutputStream.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                        try {
                            if(fileOutputStream!=null) {
                                //关闭输出流
                                fileOutputStream.close();
                            }
                            Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
            }
        });
        /***********************读取保存的信息************************/
        //查看按钮按键事件监听器
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //声明文件输入流对象
                FileInputStream fileInputStream=null;
                try {
                    //获得文件输入流对象
                    fileInputStream=openFileInput("p157_memo");
                    //实例化字节数组
                    buffer=new byte[fileInputStream.available()];
                    //从输入流中读取数据
                    fileInputStream.read(buffer);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                        try {
                            if(fileInputStream!=null) {
                                //关闭输入流对象
                                fileInputStream.close();
                            }
                            //把字节数组中的数据转换为字符串
                            String data=new String(buffer);
                            //显示读取的内容
                            editText.setText(data);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
            }
        });
    }
}