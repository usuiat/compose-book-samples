package net.engawapg.composebooksamples.kotlinusagesample

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource

@Composable
fun LambdaSample() {
    var count by remember { mutableIntStateOf(0) }
    Column {
        Text("Count = $count")
        IconButton(
            onClick = { count++ }
        ) {
            Icon(
                painter = painterResource(R.drawable.add),
                contentDescription = null
            )
        }
    }
}
