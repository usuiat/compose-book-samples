package net.engawapg.composebooksamples.performance

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.net.URL

@Immutable // 追加
data class User(
    val id: Int,
    val name: String,
    val iconUrl: URL
)

class UserModel {
    private var numOfUsers = 3
    fun fetchUsers(): List<User> {
        return List(numOfUsers) {
            User(
                id = it,
                name = "User $it",
                iconUrl = URL("https://example.com/user$it.png")
            )
        }.reversed()
    }
    fun addUser() {
        numOfUsers++
    }
}

class UserViewModel : ViewModel() {
    private val userModel = UserModel()
    private val _users = MutableStateFlow(userModel.fetchUsers())
    val users = _users.asStateFlow()
    fun addUser() {
        userModel.addUser()
        _users.value = userModel.fetchUsers()
    }
}

@Composable
fun ImmutableSample() {
    UserList()
}

@Composable
private fun UserList(viewModel: UserViewModel = viewModel()) {
    val users by viewModel.users.collectAsStateWithLifecycle()
    Column {
        Button(onClick = viewModel::addUser) {
            Text("Add User")
        }
        for (user in users) {
            key(user.id) { // 追加
                UserListItem(user)
            } // 追加
        }
    }
}
@Composable
private fun UserListItem(user: User) {
    ListItem(
        headlineContent = { Text(user.name) },
        supportingContent = { Text("ID: ${user.id}") }
    )
}
