package net.engawapg.composebooksamples.listcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import net.engawapg.composebooksamples.listcompose.ui.theme.Ch1_Sec3_2_ListComposeTheme

val countriesList = listOf(
    "Japan",
    "USA",
    "China",
    "Korea",
    "France",
    "Germany",
    "Italy",
    "Spain",
    "UK",
    "Canada",
    "Brazil",
    "Australia",
    "Mexico",
    "Russia",
    "Indonesia",
    "Turkey",
    "Netherlands",
    "Switzerland",
    "Saudi Arabia",
    "Argentina",
    "Sweden",
    "Poland",
    "Belgium",
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ch1_Sec3_2_ListComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        CountriesList()
                    }
                }
            }
        }
    }
}

@Composable
fun CountriesList() {
    LazyColumn {
        items(countriesList) { country ->
            Text(
                text = country,
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}
