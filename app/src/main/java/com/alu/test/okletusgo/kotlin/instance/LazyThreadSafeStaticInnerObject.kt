package com.alu.test.okletusgo.kotlin.instance

/**
 * Created by Alu on 2017/5/25.
 * 版本：V1.0
 *  kotlin 懒加载单例
 */
class LazyThreadSafeStaticInnerObject private constructor() {
    companion object {
        fun getInstance() = Holder.instance
    }

    private object Holder {
        val instance = LazyThreadSafeStaticInnerObject()
    }
}