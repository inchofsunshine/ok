package com.alu.test.okletusgo.kotlin.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_kotlin.*

class KotlinActivity : AppCompatActivity() {
    var a = 5
    var b = 6
    val c = 7
    val d: Int = 7
    val f: String? = "22"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.alu.test.okletusgo.R.layout.activity_kotlin)
        btn_1.setOnClickListener {
            if (et_1.text.isNotEmpty() && et_2.text.isNotEmpty())
                tv_1.text = getMax(et_1.text.toString().toInt(), (et_2.text.toString().toInt())).toString()
            println(KotlinActivity::class.java)
            println(com.spark.kotlindemo.FilePath.javaClass.toString())
        }
    }

    /**
     *
     */
    fun max(a: Int, b: Int) = if (a > b) a else b

    /**
     *
     */
    fun getMax(a: Int, b: Int): Int {
        if (a > b)
            return a
        else
            return b
    }
}
