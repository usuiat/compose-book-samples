package net.engawapg.composebooksamples.designpattern

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import java.util.SortedMap

class Sample(
    val section: Int,
    val title: String,
    val route: String,
    val content: @Composable () -> Unit
)

@Composable
fun App(chapter: Int, samples: SortedMap<Int, List<Sample>>) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "SampleList",
    ) {
        composable(route = "SampleList") {
            SampleList(
                chapter = chapter,
                samples = samples,
                onSampleClick = { sample ->
                    navController.navigate(sample.route)
                }
            )
        }
        for (section in samples) {
            for (sample in section.value) {
                composable(route = sample.route) {
                    Scaffold(Modifier.fillMaxSize()) { innerPadding ->
                        Box(Modifier.padding(innerPadding)) {
                            sample.content()
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SampleList(
    chapter: Int,
    samples: SortedMap<Int, List<Sample>>,
    onSampleClick: (Sample) -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("第${chapter}章") }
            )
        },
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            for ((section, samplesOfSection) in samples) {
                item {
                    Text(
                        text = "$chapter.$section",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            top = 32.dp,
                            bottom = 8.dp
                        )
                    )
                }
                items(samplesOfSection) { sample ->
                    ListItem(
                        headlineContent = { Text(sample.title) },
                        modifier = Modifier.clickable {
                            onSampleClick(sample)
                        }
                    )
                }
            }
        }
    }
}
