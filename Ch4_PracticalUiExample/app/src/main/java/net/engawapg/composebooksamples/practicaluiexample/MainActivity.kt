package net.engawapg.composebooksamples.practicaluiexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import net.engawapg.composebooksamples.practicaluiexample.ui.theme.PrefecturesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrefecturesTheme {
                App()
            }
        }
    }
}
