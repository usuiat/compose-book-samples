package net.engawapg.composebooksamples.kotlinusagesample

import kotlin.reflect.KProperty

fun main() {
    val some = SomeClass()
    some.someValue = 2
    some.twice()
    println("someValue = ${some.someValue}")
}

class SomeClass {
    var someValue: Int by ValueLogger()

    fun twice() {
        val x = someValue
        someValue = x * 2
    }
}

class ValueLogger {
    private var otherValue: Int = 0

    operator fun getValue(thisObj: Any?, property: KProperty<*>): Int {
        println("Get $otherValue from otherValue")
        return otherValue
    }

    operator fun setValue(thisObj: Any?, property: KProperty<*>, value: Int) {
        println("Set $value to otherValue")
        this.otherValue = value
    }
}
