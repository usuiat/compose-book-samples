package net.engawapg.composebooksamples.composemechanismsample

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
private fun CountDisplay(count: Int) {
    Text("count=$count")
    SideEffect { println("count=$count") }
}

@Composable
private fun CountDisplay(count1: Int, count2: Int) {
    Text("count1=$count1 count2=$count2")
    SideEffect { println("count1=$count1") }
}

@Composable
fun SideEffectSample() {
    Column {
        var count by remember { mutableIntStateOf(0) }
        Button(onClick = { count++ }) { Text("Button") }
        CountDisplay(count)
        CountDisplay(0)
    }
}
