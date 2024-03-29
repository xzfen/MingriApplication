package com.feng.looperpager;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * @项目名称：MingriApplication
 * @包名：com.feng.looperpager
 * @作者：FENG
 * @类名：LooperPagerAdapter
 * @创建时间：2022/11/2021:51
 * @描述：
 **/
public class LooperPagerAdapter extends PagerAdapter {
    private static final String TAG = "LooperPagerAdapter";
    private List<Integer> mPics;

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //imageView.setBackgroundColor(mPics.get(position));
        Log.d(TAG, "instantiateItem: position--> " + position);
        int realPosition = position%mPics.size();
        imageView.setImageResource(mPics.get(realPosition));
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        if (mPics != null) {
            return Integer.MAX_VALUE;
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public void setData(List<Integer> pics) {
        this.mPics = pics;
    }
}
