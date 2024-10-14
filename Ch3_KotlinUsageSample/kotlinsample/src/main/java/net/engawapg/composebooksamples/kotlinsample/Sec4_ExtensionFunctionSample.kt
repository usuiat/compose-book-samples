package net.engawapg.composebooksamples.kotlinsample

fun main(args: Array<String>) {
    val hello = "Hello"
    hello.printLength()

    val scope = PrintLengthScope()
    scope.checkLength("Hello")

    processText(text = "Hello") { println(length) }
}

fun String.printLength() {
    if (this.isNotBlank()) {
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
