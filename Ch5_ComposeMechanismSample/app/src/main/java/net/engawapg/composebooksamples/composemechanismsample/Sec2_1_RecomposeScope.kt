package net.engawapg.composebooksamples.composemechanismsample

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun RecomposeScopeSample() {
    LayoutA()
}

@Composable
private fun LayoutA() {
    LayoutB()
}

@Composable
private fun LayoutB() {
    Column {
        var count by remember { mutableIntStateOf(0) }
        Button(onClick = { count++ }) { Text("Button") }
        Text("count=$count")
        Text("Skipped")
    }
}
