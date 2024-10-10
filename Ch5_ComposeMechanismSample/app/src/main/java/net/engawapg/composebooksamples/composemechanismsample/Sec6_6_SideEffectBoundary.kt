package net.engawapg.composebooksamples.composemechanismsample

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DelayedCounter() {
    var count by remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()
    Column {
        Button(
            onClick = {
                scope.launch {
                    delay(1000)
                    count++
                }
            }
        ) { Text("Button") }
        Text("count=$count")
    }
    LaunchedEffect(Unit) {
        delay(10000)
        println("count=$count")
    }
}
