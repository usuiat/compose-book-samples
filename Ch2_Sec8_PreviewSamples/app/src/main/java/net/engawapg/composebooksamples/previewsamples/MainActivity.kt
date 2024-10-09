package net.engawapg.composebooksamples.previewsamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.engawapg.composebooksamples.previewsamples.ui.theme.PreviewSamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewSamplesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        OnOffSwitch(on = true)
                    }
                }
            }
        }
    }
}

@Composable
fun OnOffSwitch(on: Boolean) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "Off",
            style = MaterialTheme.typography.titleLarge
        )
        Switch(
            checked = on,
            onCheckedChange = {},
            modifier = Modifier.padding(horizontal = 4.dp)
        )
        Text(
            text = "On",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnOffSwitchPreview() {
    OnOffSwitch(on = true)
}

@Preview
@Composable
fun OnOffSwitchPreviewWithTheme() {
    PreviewSamplesTheme {
        Surface {
            OnOffSwitch(on = true)
        }
    }
}
