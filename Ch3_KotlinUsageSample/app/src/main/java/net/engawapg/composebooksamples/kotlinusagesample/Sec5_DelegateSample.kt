package net.engawapg.composebooksamples.kotlinusagesample

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlin.reflect.KProperty

@Composable
fun DelegateSample() {
    Column {
        Button(onClick = { runDelegateSample() }) {
            Text("Run delegate sample")
        }
    }
}

fun runDelegateSample() {
    val some = SomeClass()
    some.someValue = 2
    some.twice()
    println("someValue = ${some.someValue}")
}

class SomeClass {
    var someValue: Int by OtherClass()

    fun twice() {
        val x = someValue
        someValue = x * 2
    }
}

class OtherClass {
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
