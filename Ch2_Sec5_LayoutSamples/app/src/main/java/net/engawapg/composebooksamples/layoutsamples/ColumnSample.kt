package net.engawapg.composebooksamples.layoutsamples

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ColumnSample() {
    Column {
        Text(text = "Good Morning!")
        Text(text = "Good Afternoon!")
        Text(text = "Good Evening!")
        Text(text = "Good Night!")
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnSamplePreview() {
    ColumnSample()
}
