package net.engawapg.composebooksamples.designpattern

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NotificationSettings() {
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        var push by remember { mutableStateOf(true) }
        var mail by remember { mutableStateOf(false) }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("プッシュ通知", Modifier.width(150.dp))
            StatelessSwitch(
                enabled = push,
                onEnabledChange = { push = !push }
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("メール通知", Modifier.width(150.dp))
            StatelessSwitch(
                enabled = mail,
                onEnabledChange = { mail = !mail }
            )
        }
        ResetButton(
            push = push,
            mail = mail,
            onResetClick = {
                push = true
                mail = false
            }
        )
    }
}

@Composable
fun ResetButton(push: Boolean, mail: Boolean, onResetClick: () -> Unit) {
    val enabled = !push || mail
    TextButton(onClick = onResetClick, enabled = enabled) {
        Text("初期値に戻す")
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationSettingsPreview() {
    NotificationSettings()
}
