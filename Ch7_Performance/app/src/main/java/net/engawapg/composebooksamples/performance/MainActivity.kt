package net.engawapg.composebooksamples.performance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.engawapg.composebooksamples.performance.ui.theme.PerformanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PerformanceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
private fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "SampleList",
        modifier = modifier
    ) {
        composable(route = "SampleList") {
            LazyColumn {
                items(samples) { sample ->
                    ListItem(
                        headlineContent = { Text(sample.name) },
                        modifier = Modifier.clickable {
                            navController.navigate(sample.name)
                        }
                    )
                }
            }
        }
        for (sample in samples) {
            composable(route = sample.name) {
                sample.content()
            }
        }
    }
}

private class Sample(
    val name: String,
    val content: @Composable () -> Unit
)

private val samples = listOf(
    Sample(
        name = "再コンポーズが大量に発生する画面の例",
        content = { LayoutInspectorSample() }
    ),
    Sample(
        name = "大小の画像を表示する時間を比較する例",
        content = { ProfilerSample() }
    ),
    Sample(
        name = "フェーズ変更による改善例",
        content = { PhaseSample() }
    ),
    Sample(
        name = "derivedStateOfの利用例",
        content = { DerivedStateOfSample() }
    ),
    Sample(
        name = "Immutableとkeyの利用例",
        content = { ImmutableSample() }
    ),
    Sample(
        name = "Lazyコンポーザブルの利用例",
        content = { LazySample() }
    ),
)
