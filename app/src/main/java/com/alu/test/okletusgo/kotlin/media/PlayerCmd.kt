package com.alu.test.okletusgo.kotlin.media

/**
 * Created by Alu on 2017/5/25.
 * 版本：V1.0
 */
sealed class PlayerCmd {
    class Play(val url: String, val position: Long = 0) : PlayerCmd()

    class Seek(val position: Long) : PlayerCmd()

    object Pause : PlayerCmd()

    object Resume : PlayerCmd()

    object Stop : PlayerCmd()
}