package net.engawapg.composebooksamples.coroutinessample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    val scope = CoroutineScope(EmptyCoroutineContext)
    scope.launch {
        println("start")
        delay(1000)
        println("end")
    }

    // コルーチンの処理が終わるのを待つ
    Thread.sleep(2000L)

    scope.launch {
        println("Start 1")
        delay(1000)
        println("End 1")
    }
    scope.launch {
        println("Start 2")
        delay(1000)
        println("End 2")
    }
    scope.cancel()

    Thread.sleep(2000L)
}
