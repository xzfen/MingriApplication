package com.feng.looperpager;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private static final String TAG = "MainActivity";
    private ViewPager mLooperPager;
    private LooperPagerAdapter mLooperPagerAdapter;
    private static List<Integer> sPics = new ArrayList<>();
    static {
        sPics.add(R.mipmap.img01);
        sPics.add(R.mipmap.img02);
        sPics.add(R.mipmap.img03);
        sPics.add(R.mipmap.img04);
        sPics.add(R.mipmap.img05);
    }

    private Handler mHandler;
    private LinearLayout mPointer_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //4. 准备数据
        /*Random random = new Random();
        for (int i = 0; i < 5; i++) {
            sPics.add(Color.argb(random.nextInt(255),random.nextInt(255),random.nextInt(255),random.nextInt(255)));
        }*/
        //5. 给适配器设置数据
        mLooperPagerAdapter.setData(sPics);
        //中间点%数据的size不一定为0，所以显示的就不是第一个。
        //处理一下
        int dx = (Integer.MAX_VALUE / 2) % sPics.size();
        int targetCenterPosition = (Integer.MAX_VALUE / 2) - dx;
        //设置到中间点
        mLooperPager.setCurrentItem(targetCenterPosition, true);
        //6. 通知适配器数据变化
        mLooperPagerAdapter.notifyDataSetChanged();

        mPointer_container = findViewById(R.id.pointers_container);
        //根据图片个数添加点
        insertPointers();
        //添加事件监听器
        mLooperPager.addOnPageChangeListener(this);
        //创建一个消息处理对象
        mHandler = new Handler();
    }

    private void insertPointers() {
        for (int i = 0; i < sPics.size(); i++) {
            View point = new View(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20, 20);
            layoutParams.rightMargin = 20;
            point.setLayoutParams(layoutParams);
            point.setBackground(getDrawable(R.drawable.shape_point_normal));
            mPointer_container.addView(point);
        }
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        //当界面绑定到窗口的时候，将Runnable对象发送到消息队列
        mHandler.post(looperTask);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mHandler.removeCallbacks(looperTask);
    }

    private Runnable looperTask = new Runnable() {
        @Override
        public void run() {
            //切换viewPager里的图片到下一个
            int currentItem = mLooperPager.getCurrentItem();
            mLooperPager.setCurrentItem(++currentItem, true);
            mHandler.postDelayed(this, 3000);
        }
    };

    private void initView() {
        //1. 找到ViewPager控件
        mLooperPager = findViewById(R.id.looper_pager);

        //2. 创建适配器
        mLooperPagerAdapter = new LooperPagerAdapter();
        //3. 设置适配器
        mLooperPager.setAdapter(mLooperPagerAdapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d(TAG, "onPageSelected: " + position);
        for (int i = 0; i < mPointer_container.getChildCount(); i++) {
            View point = mPointer_container.getChildAt(i);
            if(i == position % sPics.size()) {
                point.setBackgroundResource(R.drawable.shape_point_selected);
            }else{
                point.setBackgroundResource(R.drawable.shape_point_normal);
            }

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}