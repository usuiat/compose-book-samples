package net.engawapg.composebooksamples.composemechanismsample

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Message() {
    Text("Hello")
    DisposableEffect(Unit) {
        println("Message Composed")
        onDispose {
            println("Message Disposed")
        }
    }
}

@Composable
fun DisposableEffectSample() {
    Column {
        var showMessage by remember { mutableStateOf(false) }
        Button(onClick = { showMessage = !showMessage }) { Text("Show Message") }
        if (showMessage) {
            Message()
        }
    }
}
