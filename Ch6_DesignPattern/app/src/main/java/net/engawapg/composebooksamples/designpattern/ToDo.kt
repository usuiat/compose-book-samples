package net.engawapg.composebooksamples.designpattern

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ToDoRoute(
    viewModel: ToDoViewModel = viewModel(
        factory = ToDoViewModel.Factory(toDoModel = ToDoModel())
    )
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    ToDoScreen(
        uiState = uiState,
        onCompletedChange = viewModel::updateCompleted
    )
}

@Composable
fun ToDoScreen(
    uiState: ToDoUiState,
    onCompletedChange: (toDoItem: ToDoItem, completed: Boolean) -> Unit
) {
    Column {
        Text(
            text = "TODOリスト",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().height(48.dp)
        )
        when (uiState) {
            is ToDoUiState.Loading -> Text("読み込み中...")
            is ToDoUiState.Success -> ToDoList(
                toDoItems = uiState.toDoItems,
                onCompletedChange = onCompletedChange
            )
        }
    }
}

@Composable
fun ToDoList(
    toDoItems: List<ToDoItem>,
    onCompletedChange: (toDoItem: ToDoItem, completed: Boolean) -> Unit
) {
    LazyColumn {
        items(toDoItems) { item ->
            ListItem(
                headlineContent = {
                    Text(item.title)
                },
                trailingContent = {
                    Checkbox(
                        checked = item.isCompleted,
                        onCheckedChange = { checked ->
                            onCompletedChange(item, checked)
                        }
                    )
                }
            )
        }
    }
}
