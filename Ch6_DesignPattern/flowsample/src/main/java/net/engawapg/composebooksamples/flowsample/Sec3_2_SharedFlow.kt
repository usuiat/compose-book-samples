package net.engawapg.composebooksamples.flowsample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    val flow = MutableSharedFlow<Int>()
    val scope = CoroutineScope(EmptyCoroutineContext)

    scope.launch {
        delay(1000)
        flow.emit(1)
        delay(1000)
        flow.emit(2)
    }

    scope.launch {
        flow.collect { println("Collect $it") }
    }

    Thread.sleep(3000L)
}
