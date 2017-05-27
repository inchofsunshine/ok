package com.alu.test.okletusgo.kotlin

import android.os.Bundle
import android.view.View
import com.alu.test.okletusgo.R
import com.alu.test.okletusgo.base.BaseKotlinFragment
import kotlinx.android.synthetic.main.fragment_second_kotlin.*

/**
 * Created by Alu on 2017/5/26.
 * 版本：V1.0
 */
class SecondKotlinFragment : BaseKotlinFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_second_kotlin
    }

    companion object{
        fun newInstance(): SecondKotlinFragment = SecondKotlinFragment()
    }

    override fun init(view: View?, saveInstanceState: Bundle?) {
    }
}
