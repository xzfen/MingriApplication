package com.example.p7p6_bankservicedemo.impl;

import android.os.Binder;
import android.util.Log;

import com.example.p7p6_bankservicedemo.interfaces.IBankWorkerAction;

/**
 * @项目名称：MingriApplication
 * @包名：com.example.p7p6_bankservicedemo.impl
 * @作者：FENG
 * @类名：BankWorkerImpl
 * @创建时间：2022/9/29:27
 * @描述：
 **/
public class BankWorkerActionImpl extends Binder implements IBankWorkerAction {
    private static final String TAG = "BankWorkerImpl";

    @Override
    public void queryUserCredit() {
        Log.d(TAG, "queryUserCredit: 999");
    }

    @Override
    public void freezeUserAccount() {
        Log.d(TAG, "freezeUserAccount: 0");
    }

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
