package com.alu.test.okletusgo.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.alu.test.okletusgo.R
import kotlinx.android.synthetic.main.activity_kotlin.*

class KotlinActivity : AppCompatActivity() {
    var a = 5
    var b = 6
    val c = 7
    val d: Int = 7
    val f: String? = "22"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        btn_1.setOnClickListener {
            if(et_1.text.toString().isNotEmpty()&&et_2.text.toString().isNotEmpty())
                tv_1.text = getMax(et_1.text.toString().toInt(), (et_2.text.toString().toInt())).toString()
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
