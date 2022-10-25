package com.example.b2p6_calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private TextView mCancel;
    private TextView mPlusMinus;
    private TextView mMod;
    private TextView mDevide;
    private TextView mOne;
    private TextView mTwo;
    private TextView mThree;
    private TextView mMul;
    private TextView mFour;
    private TextView mFive;
    private TextView mSix;
    private TextView mMinus;
    private TextView mSeven;
    private TextView mEight;
    private TextView mNine;
    private TextView mPlus;
    private TextView mZero;
    private TextView mPoint;
    private TextView mEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        initView();
        //设置点击事件
        initClickEvent();
    }

    //设置点击事件
    private void initClickEvent() {
        //第一种设置方式
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Content==" + ((TextView) view).getText().toString());
            }
        });
        //第二种设置方式
        mPlusMinus.setOnClickListener(this);
        mMod.setOnClickListener(this);
    }

    //初始化控件
    private void initView() {
        mCancel = this.findViewById(R.id.tv_cancel);
        mPlusMinus = this.findViewById(R.id.tv_plus_minus);
        mMod = this.findViewById(R.id.tv_mod);
        mDevide = this.findViewById(R.id.tv_devide);
        mOne = this.findViewById(R.id.tv_one);
        mTwo = this.findViewById(R.id.tv_two);
        mThree = this.findViewById(R.id.tv_three);
        mMul = this.findViewById(R.id.tv_mul);
        mFour = this.findViewById(R.id.tv_four);
        mFive = this.findViewById(R.id.tv_five);
        mSix = this.findViewById(R.id.tv_six);
        mMinus = this.findViewById(R.id.tv_minus);
        mSeven = this.findViewById(R.id.tv_seven);
        mEight = this.findViewById(R.id.tv_eight);
        mNine = this.findViewById(R.id.tv_nine);
        mPlus = this.findViewById(R.id.tv_plus);
        mZero = this.findViewById(R.id.tv_zero);
        mPoint = this.findViewById(R.id.tv_point);
        mEqual = this.findViewById(R.id.tv_equal);
    }

    @Override
    public void onClick(View view) {
        //如果有多个控件设置点击事件，那么我们这里面要统一处理，判断是哪个控件被按下
        //首选获取事件Id
        int id = view.getId();

        switch (id){
            case R.id.tv_plus_minus:
                //one被点击后的处理程序
                break;
            case R.id.tv_mod:
                //这里处理%点击事件
                break;
        }
        Log.d(TAG, "click content==" + ((TextView) view).getText().toString());
    }
}