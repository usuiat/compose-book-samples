package net.engawapg.composebooksamples.performance

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

private data class Item(
    val id: String,
    var name: String
)

private val items = List(100) { Item(id = "$it", name = "Item $it") }

@Composable
fun LayoutInspectorSample() {
    Box {
        val state = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(state)) {
            for (item in items) {
                ItemDetail(item)
            }
        }

        if (state.value == 0) {
            FloatingActionButton(
                modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp),
                onClick = {}
            ) {
                Icon(painter = painterResource(R.drawable.add), contentDescription = null)
            }
        }
    }
}

@Composable
private fun ItemDetail(item: Item) {
    Column(modifier = Modifier.padding(10.dp).fillMaxWidth()) {
        Text(
            text = item.name,
            style = MaterialTheme.typography.headlineMedium,
        )
        Text(
            text = "ID: ${item.id}",
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

