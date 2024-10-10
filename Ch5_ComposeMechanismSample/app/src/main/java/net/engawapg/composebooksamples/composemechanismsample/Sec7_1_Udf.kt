package net.engawapg.composebooksamples.composemechanismsample

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun UdfSample() {
    var checked by remember { mutableStateOf(false) }
    val onCheckedChange: (Boolean) -> Unit = { checked = it }
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange
    )
}
