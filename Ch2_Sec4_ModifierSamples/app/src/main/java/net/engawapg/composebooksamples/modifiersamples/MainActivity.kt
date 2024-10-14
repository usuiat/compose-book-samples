package net.engawapg.composebooksamples.modifiersamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.engawapg.composebooksamples.modifiersamples.ui.theme.ModifierSamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModifierSamplesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        ModifierSample()
//                        ModifierChainSample()
//                        ModifierSizeSample()
//                        ModifierBrushSample()
//                        ModifierShapeSample()
//                        ModifierPaddingSample()
//                        ModifierChainOrderSample()
//                        ModifierClickableSample()
                    }
                }
            }
        }
    }
}

@Composable
fun ModifierSample() {
    Text(
        text = "I like Compose",
        modifier = Modifier.border(1.dp, Color.Black)
    )
}

@Composable
fun ModifierChainSample() {
    Text(
        text = "I like Compose",
        modifier = Modifier
            .background(Color.LightGray)
            .border(1.dp, Color.Black)
            .padding(10.dp)
    )
}

@Composable
fun ModifierSizeSample() {
    Text(
        text = "I like Compose",
        modifier = Modifier
            .size(width = 200.dp, height = 100.dp)
    )
}

@Composable
fun ModifierBrushSample() {
    Text(
        text = "I like Compose",
        modifier = Modifier
            .size(width = 200.dp, height = 100.dp)
            .background(Brush.linearGradient(listOf(Color.White, Color.Gray)))
            .border(1.dp, Color.Black)
    )
}

@Composable
fun ModifierShapeSample() {
    Text(
        text = "I like Compose",
        modifier = Modifier
            .size(width = 200.dp, height = 100.dp)
            .background(
                brush = Brush.linearGradient(listOf(Color.White, Color.Gray)),
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(20.dp)
            )
    )
}

@Composable
fun ModifierPaddingSample() {
    Text(
        text = "I like Compose",
        modifier = Modifier
            .size(width = 200.dp, height = 100.dp)
            .background(
                brush = Brush.linearGradient(listOf(Color.White, Color.Gray)),
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(10.dp) // この1行を追加
    )
}

@Composable
fun ModifierChainOrderSample() {
    Text(
        text = "I like Compose",
        modifier = Modifier
            .size(width = 200.dp, height = 100.dp)
            .background(
                brush = Brush.linearGradient(listOf(Color.White, Color.Gray)),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(10.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(20.dp)
            )
    )
}

@Composable
fun ModifierClickableSample() {
    Text(
        text = "I like Compose",
        modifier = Modifier
            .clickable { println("Click!") }
    )
}

@Preview(showBackground = true)
@Composable
fun ModifierSamplePreview() {
    ModifierSample()
}

@Preview(showBackground = true)
@Composable
fun ModifierChainSamplePreview() {
    ModifierChainSample()
}

@Preview(showBackground = true)
@Composable
fun ModifierSizeSamplePreview() {
    ModifierSizeSample()
}

@Preview(showBackground = true)
@Composable
fun ModifierBrushSamplePreview() {
    ModifierBrushSample()
}

@Preview(showBackground = true)
@Composable
fun ModifierShapeSamplePreview() {
    ModifierShapeSample()
}

@Preview(showBackground = true)
@Composable
fun ModifierPaddingSamplePreview() {
    ModifierPaddingSample()
}

@Preview(showBackground = true)
@Composable
fun ModifierChainOrderSample1Preview() {
    ModifierChainOrderSample()
}

@Preview(showBackground = true)
@Composable
fun ModifierClickableSamplePreview() {
    ModifierClickableSample()
}
