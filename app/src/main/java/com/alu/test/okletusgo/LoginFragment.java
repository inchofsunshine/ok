package com.alu.test.okletusgo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import com.alu.test.okletusgo.base.BaseFragment;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * Created by Alu on 2017/4/25.
 * 版本：V1.0
 */

public class LoginFragment extends BaseFragment {
    public static String FIRST_FRAGMENT = "first_fragment";
    private String msg;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    public static LoginFragment newInstance(String msg) {
        LoginFragment fragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FIRST_FRAGMENT, msg);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle saveInstanceState) {
        EditText editText = (EditText) view.findViewById(R.id.et_user_nameId);
        editText.setText(msg);
        view.findViewById(R.id.loginId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        view.findViewById(R.id.registerId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(SecondFragment.newInstance("从登陆界面跳转,注册页面"));
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            msg = (String) getArguments().getSerializable(FIRST_FRAGMENT);
        }
//        SMSSDK.registerEventHandler(eventHandler); //注册短信回调
    }

    //跳转短信验证界面
    private void login() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
// 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
//                    @SuppressWarnings("unchecked")
//                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
//                    String country = (String) phoneMap.get("country");
//                    String phone = (String) phoneMap.get("phone");
                    addFragment(SecondFragment.newInstance("从登陆界面跳转的,登陆成功"));
                } else if (result == SMSSDK.RESULT_ERROR) {
                    try {
                        Throwable throwable = (Throwable) data;
                        throwable.printStackTrace();
                        JSONObject object = new JSONObject(throwable.getMessage());
                        String des = object.optString("detail");//错误描述
                        int status = object.optInt("status");//错误代码
                        if (status > 0 && !TextUtils.isEmpty(des)) {
                            Toast.makeText(getContext(), des, Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        //do something
                    }
                }
            }
        });
        registerPage.show(getContext());

//不适用GUI接口
//        SMSSDK.getSupportedCountries(); //获取短信目前支持的国家列表，在监听中返回
//
//        SMSSDK.getVerificationCode("country", "phone");  //请求获取短信验证码，在监听中返回
//
//        SMSSDK.submitVerificationCode("country", "phone", "code"); //提交短信验证码，在监听中返回


    }

//    private EventHandler eventHandler = new EventHandler() {
//        @Override
//        public void afterEvent(int event, int result, Object data) {
//            if (result == SMSSDK.RESULT_COMPLETE) {
//                //回调完成
//                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
//                    //提交验证码成功
//                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
//                    //获取验证码成功
//                } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
//                    //返回支持发送验证码的国家列表
//                }
//            }else {
//                ((Throwable)data).printStackTrace();
//            }
//        }
//
//    };


    @Override
    public void onDestroy() {
        super.onDestroy();
//        SMSSDK.unregisterEventHandler(eventHandler);
    }
}
