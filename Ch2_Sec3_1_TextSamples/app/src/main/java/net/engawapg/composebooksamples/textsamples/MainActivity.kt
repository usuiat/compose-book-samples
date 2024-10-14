package net.engawapg.composebooksamples.textsamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import net.engawapg.composebooksamples.textsamples.ui.theme.TextSamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextSamplesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        TextSample1()
//                        TextSample2()
//                        TextSample3()
                    }
                }
            }
        }
    }
}

@Composable
fun TextSample1() {
    Text("I like Compose")
}

@Composable
fun TextSample2() {
    Column {
        Text(text = "I like Compose", fontSize = 10.sp)
        Text(text = "I like Compose", fontSize = 20.sp)
        Text(text = "I like Compose", fontSize = 30.sp)
    }
}

@Composable
fun TextSample3() {
    Column {
        val story = "昔々あるところにおじいさんとおばあさんがいました。" +
                "おじいさんは山へ柴刈りに、おばあさんは川へ洗濯に行きました。"
        Text(text = story)
        Text(text = story, maxLines = 1, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun TextSample1Preview() {
    TextSample1()
}

@Preview(showBackground = true)
@Composable
fun TextSample2Preview() {
    TextSample2()
}

@Preview(showBackground = true)
@Composable
fun TextSample3Preview() {
    TextSample3()
}
