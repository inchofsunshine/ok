package com.alu.test.okletusgo.kotlin


import com.alu.test.okletusgo.base.BaseFragment
import com.alu.test.okletusgo.base.SGActivity

open class SecondKotlinActivity : SGActivity() {
    override fun getFirstFragment(): BaseFragment {
        return SecondKotlinFragment().newInstance()
    }
}
