package com.example.p7p6_bankservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;

import com.example.p7p6_bankservicedemo.impl.BankBossActionImpl;
import com.example.p7p6_bankservicedemo.impl.BankWorkerActionImpl;
import com.example.p7p6_bankservicedemo.impl.NormalUserActionImpl;

public class BankService extends Service {
    public BankService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        String action=intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            if("com.example.p7p6_bankservicedemo.ACTION_NORMAL_USER".equals(action)){
                return new NormalUserActionImpl();
            }else if("com.example.p7p6_bankservicedemo.ACTION_BANK_WORKER".equals(action)){
                return new BankWorkerActionImpl();
            }else if("com.example.p7p6_bankservicedemo.ACTION_BANK_BOSS".equals(action)){
                return new BankBossActionImpl();
            }
        }
        return null;
    }
}