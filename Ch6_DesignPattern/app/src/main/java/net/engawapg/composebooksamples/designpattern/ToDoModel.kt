package net.engawapg.composebooksamples.designpattern

import kotlinx.coroutines.delay

class ToDoModel {
    suspend fun loadToDoItems(): List<ToDoItem> {
        delay(300) // 外部API呼び出しを想定
        return FakeData.toDoItems
    }

    suspend fun updateCompleted(toDoItem: ToDoItem, completed: Boolean) {
        delay(300) // 外部API呼び出しを想定
        FakeData.updateCompleted(toDoItem, completed)
    }
}

private object FakeData {
    var toDoItems = listOf(
        ToDoItem(id = 0, title = "プレゼン資料を作成する"),
        ToDoItem(id = 1, title = "メールを送る"),
        ToDoItem(id = 2, title = "アンケートに回答する"),
        ToDoItem(id = 3, title = "議事録を作成する")
    )

    fun updateCompleted(toDoItem: ToDoItem, completed: Boolean) {
        toDoItems = toDoItems.map {
            if (it.id == toDoItem.id) {
                it.copy(isCompleted = completed)
            } else {
                it
            }
        }
    }
}

data class ToDoItem(
    val id: Int,
    val title: String,
    val isCompleted: Boolean = false
)
