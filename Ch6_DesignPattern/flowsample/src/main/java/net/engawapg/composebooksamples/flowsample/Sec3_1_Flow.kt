package net.engawapg.composebooksamples.flowsample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    val flow: Flow<Int> = flow {
        delay(1000)
        emit(1)
        delay(1000)
        emit(2)
    }

    val scope = CoroutineScope(EmptyCoroutineContext)
    scope.launch {
        flow.collect {
            println("Collect $it")
        }
    }

    Thread.sleep(5000)
}
