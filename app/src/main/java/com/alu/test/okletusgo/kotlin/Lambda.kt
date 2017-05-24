package com.alu.test.okletusgo.kotlin

import rx.Observable
import java.io.File

/**
 * Created by Alu on 2017/5/24.
 * 版本：V1.0
 */
fun main(args: Array<String>) {
    val text = File(ClassLoader.getSystemResource("input").path).readText()
    Observable.from(text
            .toCharArray()
            .asIterable()
            .filter { !it.isWhitespace() }
            .groupBy { o -> o }
            .map { print(it) })
            .subscribe()
}