package net.engawapg.composebooksamples.composemechanismsample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource

@Composable
fun CompositionTreeChangeSample() {
    Column {
        var flag by remember { mutableStateOf(false) }
        Button(onClick = { flag = !flag }) { Text("Button") }
        if (flag) {
            Row {
                Text("Text1")
                Text("Text2")
            }
        } else {
            Image(painter = painterResource(R.drawable.dog), contentDescription = null)
        }
    }
}
