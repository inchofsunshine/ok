package com.alu.test.okletusgo.kotlin.test

/**
 * Created by Alu on 2017/5/25.
 * 版本：V1.0
 */
fun main(args: Array<String>) {
    val firstName = "alu"
    val lastName = null
    println("my name is ${getName(firstName)}")
    println("my name is ${getName(firstName,lastName)}")
    println("my name is ${getName(firstName,lastName = "zyt")}")
}


fun getName(firstName: String?, lastName: String? = "unKnow"): String {
    if (com.alu.test.okletusgo.kotlin.test.hasEmpty(firstName, lastName)) {
        lastName?.let { return@getName "${checkName(firstName)} $lastName" }
        firstName?.let { return@getName "$firstName ${checkName(lastName)}" }

    }
    return "$firstName $lastName"
}

fun hasEmpty(vararg strArray: String?): Boolean {
    for (str in strArray) {
        str ?: return true
    }
    return false
}

fun checkName(name: String?): String = name ?: "unKnow"
