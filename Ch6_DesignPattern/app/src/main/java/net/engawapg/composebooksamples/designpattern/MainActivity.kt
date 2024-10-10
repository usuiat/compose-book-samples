package net.engawapg.composebooksamples.designpattern

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.engawapg.composebooksamples.designpattern.ui.theme.Ch6_DesignPatternTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ch6_DesignPatternTheme {
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
        name = "ステートフルなスイッチ",
        content = { MySwitchSample1() }
    ),
    Sample(
        name = "ステートレスなスイッチ",
        content = { MySwitchSample2() }
    ),
    Sample(
        name = "通知設定のサンプル",
        content = { NotificationSettings() }
    ),
    Sample(
        name = "カラフルなボックス",
        content = { ColorfulBoxSample() }
    ),
    Sample(
        name = "TODOリスト",
        content = { ToDoRoute() }
    ),
)
