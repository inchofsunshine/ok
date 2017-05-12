package com.alu.test.okletusgo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.alu.test.okletusgo.base.BaseFragment;

/**
 * Created by Alu on 2017/4/25.
 * 版本：V1.0
 */

public class SecondFragment extends BaseFragment {
    private String msg;
    public static String SECOND_FRAGMENT = "second_fragment";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_second;
    }

    @Override
    protected void initView(View view, Bundle saveInstanceState) {
        TextView textView = (TextView) view.findViewById(R.id.tv_second_fragmentId);
        textView.setText(msg);
    }

    public static SecondFragment newInstance(String str) {
        SecondFragment sFragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(SECOND_FRAGMENT, str);
        sFragment.setArguments(bundle);
        return sFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != getArguments()) {
            msg = (String) getArguments().getSerializable(SECOND_FRAGMENT);
        }
    }
}
