package net.engawapg.composebooksamples.composemechanismsample

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

private data class User(
//    var userName: String // varで定義するとUserは不安定になる
    val userName: String
)

@Composable
fun SkippingModeSample() {
    var count by remember { mutableIntStateOf(0) }
//    val user = remember { User(userName = "suzuki") }
    var user by remember { mutableStateOf(User(userName = "suzuki")) }
    Column {
        Button(
            onClick = {
                count++
//                user.userName = "tanaka"
                user = user.copy(userName = "tanaka")
            }
        ) { Text("Button") }
        CountComposable(count = count)
        UserComposable(user = user)
    }
}

@Composable
private fun CountComposable(count: Int) {
    Text("count=$count")
}

@Composable
private fun UserComposable(user: User) {
    Text("userName=${user.userName}")
}
