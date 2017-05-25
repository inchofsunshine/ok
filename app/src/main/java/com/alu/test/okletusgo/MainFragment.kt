package com.alu.test.okletusgo

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.alu.test.okletusgo.base.BaseFragment
import com.alu.test.okletusgo.kotlin.KotlinActivity
import com.alu.test.okletusgo.myview.MyViewActivity
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Created by Alu on 2017/4/24.
 * 版本：V1.0
 */

class MainFragment : BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }

    override fun initView(view: View, saveInstanceState: Bundle) {
        btn_go_second_fragmentId.setOnClickListener { addFragment(SecondFragment.newInstance("从主界面跳转的")) }
        btn_viewId.setOnClickListener { MyViewActivity.actionStart(context) }
       btn_go_third_fragmentId.setOnClickListener {
            val intent = Intent(context, LoginActivity::class.java)
            val data = Bundle()
            data.putString("username", "lubowen")
            intent.putExtras(data)
            startActivity(intent)
        }
      btn_go_kotlin_activity.setOnClickListener { startActivity(Intent(context, KotlinActivity::class.java)) }
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}
