package net.engawapg.composebooksamples.performance

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DerivedStateOfSampleBefore() {
    ListWithConditionalButton()
}

@Composable
private fun ListWithConditionalButton() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val itemCount = 100
        val listState = rememberLazyListState()
        LazyColumn(state = listState, modifier = Modifier.weight(1f)) {
            items(itemCount) { index ->
                Text(
                    "Item $index",
                    modifier = Modifier.fillMaxWidth().height(50.dp)
                )
            }
        }
        val buttonEnabled = listState.firstVisibleItemIndex > itemCount / 2
        Button(
            enabled = buttonEnabled,
            onClick = {}
        ) { Text("Button") }
    }
}
