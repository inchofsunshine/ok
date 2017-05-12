package com.alu.test.okletusgo.myview;

import android.content.Context;
import android.content.Intent;

import com.alu.test.okletusgo.base.BaseFragment;
import com.alu.test.okletusgo.base.SGActivity;

/**
 * Created by Alu on 2017/5/12.
 * 版本：V1.0
 */

public class MyViewActivity extends SGActivity {

    @Override
    public BaseFragment getFirstFragment() {
        return MyViewFragment.newInstance();
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MyViewActivity.class);
        context.startActivity(intent);
    }
}
