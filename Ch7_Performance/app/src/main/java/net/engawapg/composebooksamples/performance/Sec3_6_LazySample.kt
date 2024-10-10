package net.engawapg.composebooksamples.performance

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun LazySample() {
    var showList by remember { mutableStateOf(false) }
    if (showList) {
        LargeList()
    } else {
        Button(onClick = { showList = true }) { Text("Show List") }
    }
}

@Composable
fun LargeList() {
    // 改善前
//    Column {
//         repeat(1000) {
    LazyColumn {
        items(1000) {
            ListItem(
                headlineContent = { Text("Item $it") }
            )
        }
    }
}

