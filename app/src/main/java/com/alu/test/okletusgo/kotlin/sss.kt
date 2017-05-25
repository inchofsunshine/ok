package com.alu.test.okletusgo.kotlin

import com.spark.kotlindemo.FilePath

/**
 * Created by Alu on 2017/5/23.
 * 版本：V1.0
 */
fun main(args:Array<String>):Unit {
    print("Hello Kotlin！")
    args.map(::println)
    for (arg in args)
        println(arg)
}