package com.alu.test.okletusgo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alu.test.okletusgo.base.BaseFragment;
import com.alu.test.okletusgo.kotlin.KotlinActivity;
import com.alu.test.okletusgo.myview.MyViewActivity;

/**
 * Created by Alu on 2017/4/24.
 * 版本：V1.0
 */

public class MainFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(View view, Bundle saveInstanceState) {
        view.findViewById(R.id.btn_go_second_fragmentId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(SecondFragment.newInstance("从主界面跳转的"));
            }
        });
        view.findViewById(R.id.btn_viewId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyViewActivity.actionStart(getContext());
            }
        });
        view.findViewById(R.id.btn_go_third_fragmentId).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getContext(),LoginActivity.class);
                Bundle data = new Bundle();
                data.putString("username", "lubowen");
                intent.putExtras(data);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.btn_go_kotlin_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), KotlinActivity.class));
            }
        });
    }
    public static  MainFragment newInstance(){
        return new MainFragment();
    }
}
