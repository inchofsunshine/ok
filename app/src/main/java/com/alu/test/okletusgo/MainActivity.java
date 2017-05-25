package com.alu.test.okletusgo;


import com.alu.test.okletusgo.base.BaseFragment;
import com.alu.test.okletusgo.base.SGActivity;

public class MainActivity extends SGActivity {
    @Override
    public BaseFragment getFirstFragment() {
        return MainFragment.Companion.newInstance();
    }
}
