package com.alu.test.okletusgo;

import android.content.Intent;
import android.os.Bundle;

import com.alu.test.okletusgo.base.BaseFragment;
import com.alu.test.okletusgo.base.SGActivity;

/**
 * Created by Alu on 2017/4/25.
 * 版本：V1.0
 */

public class LoginActivity extends SGActivity {
    private String userName;

    @Override
    protected void handleIntent(Intent intent) {
        super.handleIntent(intent);
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            userName = bundle.getString("username");
        }
    }

    @Override
    public BaseFragment getFirstFragment() {
        return LoginFragment.newInstance(userName);
    }

}
