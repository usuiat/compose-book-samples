package net.engawapg.composebooksamples.composemechanismsample

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CoroutineScopeSample() {
    val scope = rememberCoroutineScope()
    var text by remember { mutableStateOf("Hello") }
    Column {
        Button(onClick = {
            scope.launch {
                delay(3000)
                text = "Hello, Compose"
            }
        }) { Text("Button") }
        Text(text)
    }
}
