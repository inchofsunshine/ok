package com.alu.test.okletusgo.kotlin.test

/**
 * Created by Alu on 2017/5/25.
 * 版本：V1.0
 * 尾递归 10000!
 */

class Result(var value: java.math.BigInteger = java.math.BigInteger.valueOf(1L))

tailrec fun factorial(num: Int, result: com.alu.test.okletusgo.kotlin.test.Result) {
    if (num == 0) result.value = result.value.times(java.math.BigInteger.valueOf(1L))
    else {
        result.value = result.value.times(java.math.BigInteger.valueOf(num.toLong()))
        com.alu.test.okletusgo.kotlin.test.factorial(num - 1, result)
    }
}

fun main(args: Array<String>) {
    val result = com.alu.test.okletusgo.kotlin.test.Result()
    com.alu.test.okletusgo.kotlin.test.factorial(10000, result)
    print(result.value)
}