package net.engawapg.composebooksamples.kotlinusagesample

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ExtensionFunctionSample() {
    Column {
        Button(onClick = { runExtensionFunctionSample() }) {
            Text("Run extension function sample")
        }
    }
}

fun runExtensionFunctionSample() {
    val hello = "Hello"
    hello.printLength()

    val scope = PrintLengthScope()
    scope.checkLength("Hello")

    processText(text = "Hello") { println(length) }
}

fun String.printLength() {
    if (isNotBlank()) {
        println(length)
    }
}

class PrintLengthScope() {
    fun String.printLength() {
        println(length)
    }

    fun checkLength(text: String) {
        text.printLength()
    }
}

fun processText(text: String, printLength: String.() -> Unit) {
    text.printLength()
}
