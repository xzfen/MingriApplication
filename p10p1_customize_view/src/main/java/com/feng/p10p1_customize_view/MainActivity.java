package com.feng.p10p1_customize_view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.feng.p10p1_customize_view.customview.InputNumberView;

public class MainActivity extends AppCompatActivity implements InputNumberView.OnNumberChangeListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputNumberView view = findViewById(R.id.input_number_view);
        view.setOnNumberChangeListener(this);
    }

    @Override
    public void onNumberChange(int value) {
        Log.d(TAG, "onNumberChange:--> " + value);
    }
}