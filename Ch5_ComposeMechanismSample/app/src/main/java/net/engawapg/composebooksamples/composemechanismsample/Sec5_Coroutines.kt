package net.engawapg.composebooksamples.composemechanismsample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    val scope = CoroutineScope(EmptyCoroutineContext)

    println("launchでコルーチンを起動する例")

    scope.launch {
        println("start")
        delay(1000)
        println("end")
    }

    Thread.sleep(2000L) // コルーチンの処理が終わるのを待つ

    println("複数のコルーチンを起動する例")

    scope.launch {
        println("Start 1")
        delay(1000)
        println("End 1")
    }
    scope.launch {
        println("Start 2")
        delay(500)
        println("End 2")
    }

    Thread.sleep(2000L) // コルーチンの処理が終わるのを待つ

    println("コルーチンスコープをキャンセルする例")

    scope.launch {
        println("Start 1")
        delay(1000)
        println("End 1")
    }
    scope.launch {
        println("Start 2")
        delay(500)
        println("End 2")
    }
    scope.cancel()

    Thread.sleep(2000L) // コルーチンの処理が終わるのを待つ
}
