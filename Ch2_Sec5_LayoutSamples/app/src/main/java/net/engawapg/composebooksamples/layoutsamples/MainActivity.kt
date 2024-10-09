package net.engawapg.composebooksamples.layoutsamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.engawapg.composebooksamples.layoutsamples.ui.theme.Ch2_Sec5_LayoutSamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ch2_Sec5_LayoutSamplesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        ColumnSample()
//                        RowSample()
//                        BoxSample()
//                        AbsoluteSizeSample()
//                        RelativeToParentSizeSample()
//                        RelativeToSiblingsSample1()
//                        RelativeToSiblingsSample2()
//                        SpacerSample()
//                        PaddingSample()
//                        ArrangementSample(Arrangement.Top)
//                        AlignmentSample1(Alignment.Start)
//                        AlignmentSample2()
//                        NestedLayoutSample()
                    }
                }
            }
        }
    }
}