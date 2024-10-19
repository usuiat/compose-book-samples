package net.engawapg.composebooksamples.kotlinusagesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.engawapg.composebooksamples.kotlinusagesample.ui.theme.KotlinUsageSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinUsageSampleTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(32.dp)
                    ) {
                        // Section 2
                        DialogSample()
                        OutlinedTextFieldSample1()
                        OutlinedTextFieldSample2()

                        // Section 3
                        LambdaSample()

                        // Section 4
                        ExtensionFunctionSample()

                        // Section 5
                        DelegateSample()
                    }
                }
            }
        }
    }
}
