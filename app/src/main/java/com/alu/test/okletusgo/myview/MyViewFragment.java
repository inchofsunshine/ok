package com.alu.test.okletusgo.myview;

import android.os.Bundle;
import android.view.View;

import com.alu.test.okletusgo.R;
import com.alu.test.okletusgo.base.BaseFragment;

/**
 * Created by Alu on 2017/5/12.
 * 版本：V1.0
 */

public class MyViewFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_view_fragment;
    }

    @Override
    protected void initView(View view, Bundle saveInstanceState) {

    }

    public static MyViewFragment newInstance() {
        return new MyViewFragment();
    }
}
