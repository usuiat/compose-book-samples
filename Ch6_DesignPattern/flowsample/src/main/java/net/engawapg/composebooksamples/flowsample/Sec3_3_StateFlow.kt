package net.engawapg.composebooksamples.flowsample

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

fun main() {
    val sample = SampleClass()

    sample.setNewValue(1)
    println(sample.getCurrentValue())

    sample.increment()
    println(sample.getCurrentValue())
}

class SampleClass {
    val flow = MutableStateFlow(0)

    // 値の書き込み
    fun setNewValue(newValue: Int) {
        flow.value = newValue
    }

    // 値の読み取り
    fun getCurrentValue() = flow.value

    // 値の更新
    fun increment() {
        flow.update { it + 1 }
    }
}
