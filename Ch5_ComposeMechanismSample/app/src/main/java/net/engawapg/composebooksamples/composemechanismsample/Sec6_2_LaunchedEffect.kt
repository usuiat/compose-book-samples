package net.engawapg.composebooksamples.composemechanismsample

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
private fun CountDisplay(count1: Int, count2: Int) {
    Text("count1=$count1 count2=$count2")
    LaunchedEffect(count1) { println("count1=$count1") }
}

@Composable
fun LaunchedEffectSample() {
    Column {
        var count1 by remember { mutableIntStateOf(0) }
        var count2 by remember { mutableIntStateOf(0) }
        Button(onClick = { count1++ }) { Text("Count1") }
        Button(onClick = { count2++ }) { Text("Count2") }
        CountDisplay(count1 = count1, count2 = count2)
    }
}
