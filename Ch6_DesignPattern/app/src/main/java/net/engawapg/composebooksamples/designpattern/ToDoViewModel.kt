package net.engawapg.composebooksamples.designpattern

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ToDoViewModel(private val toDoModel: ToDoModel) : ViewModel() {
    private val toDoItems: MutableStateFlow<List<ToDoItem>?> =
        MutableStateFlow(null)

    init {
        viewModelScope.launch {
            toDoItems.value = toDoModel.loadToDoItems()
        }
    }

    val uiState: StateFlow<ToDoUiState> = toDoItems.map { toDoItems ->
        if (toDoItems == null) {
            ToDoUiState.Loading
        } else {
            ToDoUiState.Success(toDoItems = toDoItems)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ToDoUiState.Loading
    )

    fun updateCompleted(toDoItem: ToDoItem, completed: Boolean) {
        viewModelScope.launch {
            toDoModel.updateCompleted(toDoItem, completed)
            toDoItems.value = toDoModel.loadToDoItems()
        }
    }

    class Factory(
        private val toDoModel: ToDoModel,
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel> create(modelClass: Class<T>) =
            ToDoViewModel(toDoModel) as T
    }
}

sealed interface ToDoUiState {
    data object Loading: ToDoUiState
    data class Success(
        val toDoItems: List<ToDoItem>
    ) : ToDoUiState
}
