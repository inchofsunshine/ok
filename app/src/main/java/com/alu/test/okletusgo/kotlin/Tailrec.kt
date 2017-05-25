package com.alu.test.okletusgo.kotlin

import java.math.BigInteger

/**
 * Created by Alu on 2017/5/25.
 * 版本：V1.0
 * 递归 10000!
 */

class Result(var value: BigInteger = BigInteger.valueOf(1L))

tailrec fun factorial(num: Int, result: Result) {
    if (num == 0) result.value = result.value.times(BigInteger.valueOf(1L))
    else {
        result.value = result.value.times(BigInteger.valueOf(num.toLong()))
        factorial(num - 1, result)
    }
}

fun main(args: Array<String>) {
    val result = Result()
    factorial(10000, result)
    print(result.value)
}