package net.engawapg.composebooksamples.composemechanismsample

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

@Composable
fun RememberUpdatedStateSample() {
    var count by remember { mutableIntStateOf(0) }
    Column {
        Button(onClick = { count++ }) { Text("count=$count") }
        PrintCountAfterDelay(count = count)
    }
}

@Composable
fun PrintCountAfterDelay(count: Int) {
    val updatedCount by rememberUpdatedState(newValue = count)
    LaunchedEffect(Unit) {
        delay(3000)
        println("count=$updatedCount")
    }
}

//@Composable
//fun PrintCountAfterDelay(count: Int) {
//    LaunchedEffect(Unit) {
//        delay(3000)
//        println("count=$count") // 必ず0が表示される
//    }
//}

//@Composable
//fun PrintCountAfterDelay(count: Int) {
//    LaunchedEffect(count) { // countが更新されるたびに3秒の遅延が発生する
//        delay(3000)
//        println("count=$count")
//    }
//}
