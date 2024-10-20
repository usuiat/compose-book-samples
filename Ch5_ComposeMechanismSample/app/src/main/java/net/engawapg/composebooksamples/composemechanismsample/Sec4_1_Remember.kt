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
fun RememberKeySample1() {
    Column {
        var x by remember { mutableIntStateOf(0) }
        Button(onClick = { x++ }) { Text("Change x") }
        RandomText(x = x)
    }
}

@Composable
fun RandomText(x: Int) {
    val y = remember { Math.random() }
    Text("x=$x, y=$y")
}

@Composable
fun RememberKeySample2() {
    Column {
        var x by remember { mutableIntStateOf(0) }
        var key by remember { mutableIntStateOf(0) }
        Button(onClick = { x++ }) { Text("Change x") }
        Button(onClick = { key++ }) { Text("Change key") }
        RandomText(x = x, key = key)
    }
}

@Composable
fun RandomText(x: Int, key: Int) {
    val y = remember(key) { Math.random() }
    Text("x=$x, y=$y key=$key")
}

@Composable
fun WithoutRememberSample() {
    var count by mutableIntStateOf(0)
    Column {
        Button(onClick = { count++ }) { Text("Button") }
        Text("count=$count")
    }
}
