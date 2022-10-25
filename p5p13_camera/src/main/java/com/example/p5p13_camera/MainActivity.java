package com.example.p5p13_camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_FOR_PIC = 1;
    private ImageView mImageContainer;
    private ImageView mTakePhoto_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initListener();
    }

    private void initListener() {
        mTakePhoto_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //处理拍照按钮被点击
                //startActivityForResult();
                Intent intent = new Intent();
                intent.setAction("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent,REQUEST_CODE_FOR_PIC);
            }
        });
    }

    private void initView() {
        mImageContainer = findViewById(R.id.photo_result_container);
        mTakePhoto_btn = findViewById(R.id.take_photo_bt);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQUEST_CODE_FOR_PIC:
                //处理拍照回传的照片
                if(resultCode==Activity.RESULT_OK && data!=null){
                    //说明成功返回照片
                    Bitmap result = data.getParcelableExtra("data");
                    if (result!=null) {
                        mImageContainer.setImageBitmap(result);
                    }
                }else if(resultCode==Activity.RESULT_CANCELED){
                    //取消或者无效
                    Toast.makeText(this,"取消了拍照",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}