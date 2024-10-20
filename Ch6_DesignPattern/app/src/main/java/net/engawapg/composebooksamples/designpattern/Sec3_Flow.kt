package net.engawapg.composebooksamples.designpattern

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Composable
fun FlowSamples() {
    val coroutineScope = rememberCoroutineScope()
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        FlowSample()
        SharedFlowSample()
        StateFlowSample()
    }
}

@Composable
fun FlowSample() {
    val flow: Flow<Int> = flow {
        delay(1000)
        emit(1)
        delay(1000)
        emit(2)
    }

    val coroutineScope = rememberCoroutineScope()
    Button(
        onClick = {
            coroutineScope.launch {
                flow.collect {
                    println("Collect $it")
                }
            }
        }
    ) {
        Text("Run Flow Sample")
    }
}

@Composable
fun SharedFlowSample() {
    val flow = MutableSharedFlow<Int>()

    val coroutineScope = rememberCoroutineScope()
    Button(
        onClick = {
            coroutineScope.launch {
                delay(1000)
                flow.emit(1)
                delay(1000)
                flow.emit(2)
            }

            coroutineScope.launch {
                flow.collect { println("Collect $it") }
            }
        }
    ) {
        Text("Run SharedFlow Sample")
    }
}

@Composable
fun StateFlowSample() {
    val flow = MutableStateFlow(0)

    Button(
        onClick = {
            // 値の書き込み
            flow.value = 1
            // 値の読み取り
            println("value=${flow.value}")

            // 値の更新
            flow.update { it + 1 }
            println("value=${flow.value}")
        }
    ) {
        Text("Run StateFlow Sample")
    }
}
