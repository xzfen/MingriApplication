package com.feng.p10p1_customize_view.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.feng.p10p1_customize_view.R;

/**
 * @项目名称：MingriApplication
 * @包名：com.feng.p10p1_customize_view.customview
 * @作者：FENG
 * @类名：InputNumberView
 * @创建时间：2022/12/1512:18
 * @描述：
 **/
public class InputNumberView extends RelativeLayout {
    private int mCurrentNumber;
    private View mMinusBtn;
    private EditText mValueEdt;
    private View mPlusBtn;
    private OnNumberChangeListener mOnNumberChangeListener;

    public InputNumberView(Context context) {
        this(context,null);
    }

    public InputNumberView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InputNumberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化View
        initView(context);
        //设置事件
        setupEvent();
    }

    private void setupEvent() {
        mMinusBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentNumber--;
                updateEdtText();
            }
        });
        mPlusBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentNumber++;
                updateEdtText();
            }
        });
    }

    private void initView(Context context) {
        //View view = LayoutInflater.from(context).inflate(R.layout.input_number_view, this, true);
        View view = LayoutInflater.from(context).inflate(R.layout.input_number_view, this, false);
        addView(view);
        mMinusBtn = findViewById(R.id.minus_btn);
        mValueEdt = findViewById(R.id.value_ed);
        mPlusBtn = findViewById(R.id.plus_btn);
    }

    public int getCurrentNumber() {
        return mCurrentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        mCurrentNumber = currentNumber;
        this.updateEdtText();
    }

    private void updateEdtText(){
        mValueEdt.setText(String.valueOf(mCurrentNumber));
        if (mOnNumberChangeListener != null) {
            mOnNumberChangeListener.onNumberChange(mCurrentNumber);
        }
    }

    public void setOnNumberChangeListener(OnNumberChangeListener listener){
        this.mOnNumberChangeListener = listener;
    }

    public interface OnNumberChangeListener {
        void onNumberChange(int value);
    };
}
