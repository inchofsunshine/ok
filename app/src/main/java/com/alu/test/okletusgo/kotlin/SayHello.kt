package com.alu.test.okletusgo.kotlin

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
        fun parse(name: String): Lang {
            return Lang.valueOf(name.toUpperCase())
        }
    }
}

fun main(args: Array<String>) {
    if (args.isEmpty()) return
    val lang = Lang.parse(args[0])
    println(lang)
    lang.sayHello()
    lang.sayBye()
}

fun Lang.sayBye() {
    val bye = when (this) {

        Lang.ENGLISH -> "Bye Bye"
        Lang.CHINESE -> "再见"
        Lang.JAPANESE -> "じゃあね"
    }
    print(bye)
}