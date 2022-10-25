package com.example.p7p6_bankservicedemo.impl;

import android.os.Binder;
import android.util.Log;

import com.example.p7p6_bankservicedemo.interfaces.INormalUserAction;

/**
 * @项目名称：MingriApplication
 * @包名：com.example.p7p6_bankservicedemo.impl
 * @作者：FENG
 * @类名：NormalUserImpl
 * @创建时间：2022/9/29:24
 * @描述：
 **/
public class NormalUserActionImpl extends Binder implements INormalUserAction {
    private static final String TAG = "NormalUserImpl";

    @Override
    public void saveMoney(float money) {
        Log.d(TAG, "saveMoney: "+money);
    }

    @Override
    public float getMoney() {
        Log.d(TAG, "getMoney: 100.00");
        return 100.00f;
    }

    @Override
    public float loanMoney() {
        Log.d(TAG, "loanMoney: 99999.99");
        return 99999.99f;
    }
}
