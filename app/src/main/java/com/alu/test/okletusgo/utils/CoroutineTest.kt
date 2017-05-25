package com.spark.kotlindemo

import java.util.concurrent.Executors
import kotlin.coroutines.experimental.*

/**
 * Created by lenovo on 2017/5/25.
 *
 */
fun main(args: Array<String>) {
    log("before coroutine")
    // start the coroutine
    asyncCalcMd5("test.zip") {
        log("in corountine,before suspend")
        val result: String = suspendCoroutine {
            continuation ->
            log("in suspend block.")
            executor.submit {
                continuation.resume(calcMd5(continuation.context[FilePath]!!.path))
                //continuation.resume("without null ")
                log("after resume")
            }
        }
        log("in coroutine. After suspend. result = $result")
    }
    log("after coroutine")
}

fun log(str: String) {
    println(str)
}

class FilePath(val path: String) : AbstractCoroutineContextElement(FilePath) {
    companion object Key : CoroutineContext.Key<FilePath>
}

fun asyncCalcMd5(path: String, block: suspend () -> Unit) {
    val continuation = object : Continuation<Unit> {
        override val context: CoroutineContext
            get() = FilePath(path)

        override fun resume(value: Unit) {
            log("resume: $value")
        }

        override fun resumeWithException(exception: Throwable) {
            log(exception.toString())
        }
    }
    block.startCoroutine(continuation)
}

fun calcMd5(path: String): String {
    log("calc md5 for $path")
    Thread.sleep(1000)
    return System.currentTimeMillis().toString()
}

private val executor = Executors.newSingleThreadExecutor() {
    Thread(it, "scheduler")
}

/*
public interface ContinuationInterceptor : CoroutineContext.Element {
    companion object Key : CoroutineContext.Key<ContinuationInterceptor>

    public fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T>
}*/

