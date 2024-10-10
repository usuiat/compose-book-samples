package net.engawapg.composebooksamples.designpattern

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MySwitchSample2() {
    var enabled by remember { mutableStateOf(false) }
    StatelessSwitch(
        enabled = enabled,
        onEnabledChange = { enabled = it }
    )
}

@Composable
fun StatelessSwitch(enabled: Boolean, onEnabledChange: (Boolean) -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(width = 70.dp, height = 30.dp)
            .border(width = 1.dp, color = Color.Gray)
            .background(color = if (enabled) Color.Green else Color.White)
            .clickable { onEnabledChange(!enabled) }
    ) {
        Text(text = if (enabled) "ON" else "OFF")
    }
}

@Preview(showBackground = true)
@Composable
fun SwitchOffPreview() {
    StatelessSwitch(false) { }
}

@Preview(showBackground = true)
@Composable
fun SwitchOnPreview() {
    StatelessSwitch(true) { }
}
