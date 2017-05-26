package com.alu.test.okletusgo.kotlin.test

/**
 * Created by Alu on 2017/5/24.
 * 版本：V1.0
 */
fun main(args: Array<String>) {
    val text = java.io.File(ClassLoader.getSystemResource("input").path).readText()
    rx.Observable.from(text
            .toCharArray()
            .asIterable()
            .filter { !it.isWhitespace() }
            .groupBy { o -> o }
            .map { print(it) })
            .subscribe()
}