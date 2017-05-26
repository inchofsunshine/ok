package com.alu.test.okletusgo.kotlin.test

/**
 * Created by Alu on 2017/5/24.
 * 版本：V1.0
 */
enum class Lang(val hello: String) {
    ENGLISH("HEllo"),
    CHINESE("你好"),
    JAPANESE("こんにちは");

    fun sayHello() {
        println(hello)
    }

    companion object {
        fun parse(name: String): com.alu.test.okletusgo.kotlin.test.Lang {
            return com.alu.test.okletusgo.kotlin.test.Lang.valueOf(name.toUpperCase())
        }
    }
}

fun main(args: Array<String>) {
    if (args.isEmpty()) return
    val lang = com.alu.test.okletusgo.kotlin.test.Lang.Companion.parse(args[0])
    println(lang)
    lang.sayHello()
    lang.sayBye()
}

fun com.alu.test.okletusgo.kotlin.test.Lang.sayBye() {
    val bye = when (this) {

        com.alu.test.okletusgo.kotlin.test.Lang.ENGLISH -> "Bye Bye"
        com.alu.test.okletusgo.kotlin.test.Lang.CHINESE -> "再见"
        com.alu.test.okletusgo.kotlin.test.Lang.JAPANESE -> "じゃあね"
    }
    print(bye)
}