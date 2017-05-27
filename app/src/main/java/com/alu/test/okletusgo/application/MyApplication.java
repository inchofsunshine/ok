package com.alu.test.okletusgo.application;

import android.app.Application;
import android.content.Context;

import cn.smssdk.SMSSDK;

/**
 * Created by Alu on 2017/4/25.
 * 版本：V1.0
 */

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        SMSSDK.initSDK(this, "1d539c248fec4", "e6543a3d25046d5c1e26b66ae0b0a123");
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
