package com.alu.test.okletusgo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by Alu on 2017/5/26.
 * 版本：V1.0
 */

public abstract class BaseKotlinFragment extends BaseFragment {
    @Override
    protected abstract int getLayoutId();

    @Override
    protected void initView(View view, Bundle saveInstanceState) {
    }

    protected abstract void init(View view, Bundle saveInstanceState);

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        init(view, savedInstanceState);
    }
}
