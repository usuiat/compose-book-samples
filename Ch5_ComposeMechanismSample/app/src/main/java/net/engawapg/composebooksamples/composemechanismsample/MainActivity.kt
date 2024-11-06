package net.engawapg.composebooksamples.composemechanismsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import net.engawapg.composebooksamples.composemechanismsample.ui.theme.ComposeMechanismSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMechanismSampleTheme {
                App()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "SampleList",
        modifier = modifier
    ) {
        composable(route = "SampleList") {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = { Text("第5章") }
                    )
                },
            ) { innerPadding ->
                LazyColumn(modifier = Modifier.padding(innerPadding)) {
                    for ((section, samples) in samples) {
                        item {
                            Text(
                                text = "5.$section",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(
                                    start = 16.dp,
                                    top = 32.dp,
                                    bottom = 8.dp
                                )
                            )
                        }
                        items(samples) { sample ->
                            ListItem(
                                headlineContent = { Text(sample.title) },
                                modifier = Modifier.clickable {
                                    navController.navigate(sample.route)
                                }
                            )
                        }
                    }
                }
            }
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

private class Sample(
    val section: Int,
    val title: String,
    val route: String,
    val content: @Composable () -> Unit
)

private val samples = listOf(
    Sample(
        section = 2,
        title = "再コンポーズの起点、範囲、スキップ",
        route = "RecomposeScopeSample",
        content = { RecomposeScopeSample() }
    ),
    Sample(
        section = 2,
        title = "コンポジションの構造の変更",
        route = "CompositionTreeChangeSample",
        content = { CompositionTreeChangeSample() }
    ),
    Sample(
        section = 3,
        title = "Strong Skipping Modeが有効かどうかで挙動が変わる例と修正方法",
        route = "StrongSkippingModeSample",
        content = { SkippingModeSample() }
    ),
    Sample(
        section = 4,
        title = "keyを指定せずにrememberを利用する例",
        route = "RememberWithoutKeySample",
        content = { RememberKeySample1() }
    ),
    Sample(
        section = 4,
        title = "keyを指定してrememberを利用する例",
        route = "RememberWithKeySample",
        content = { RememberKeySample2() }
    ),
    Sample(
        section = 4,
        title = "rememberを使わずにStateを使うとうまく動かない例",
        route = "StateWithoutRememberSample",
        content = { WithoutRememberSample() }
    ),
    Sample(
        section = 4,
        title = "基本的なrememberSaveableの利用例",
        route = "BasicRememberSaveableSample",
        content = { RememberSaveableSample() }
    ),
    Sample(
        section = 4,
        title = "ParcelizeによるrememberSaveableへの対応例",
        route = "ParcelableClassUsageSample",
        content = { ParcelableClassUsageSample() }
    ),
    Sample(
        section = 4,
        title = "独自のSaverによるrememberSaveableへの対応例",
        route = "CustomSaverUsageSample",
        content = { SaverUsageSample() }
    ),
    Sample(
        section = 6,
        title = "SideEffectの利用例",
        route = "SideEffectSample",
        content = { SideEffectSample() }
    ),
    Sample(
        section = 6,
        title = "LaunchedEffectの利用例",
        route = "LaunchedEffectSample",
        content = { LaunchedEffectSample() }
    ),
    Sample(
        section = 6,
        title = "DisposableEffectの利用例",
        route = "DisposableEffectSample",
        content = { DisposableEffectSample() }
    ),
    Sample(
        section = 6,
        title = "rememberCoroutineScopeの利用例",
        route = "RememberCoroutineScopeSample",
        content = { CoroutineScopeSample() }
    ),
    Sample(
        section = 6,
        title = "rememberUpdatedStateの利用例",
        route = "RememberUpdatedStateSample",
        content = { RememberUpdatedStateSample() }
    ),
    Sample(
        section = 6,
        title = "Composeの作用と副作用の境界を説明する例",
        route = "SideEffectBoundarySample",
        content = { DelayedCounter() }
    ),
    Sample(
        section = 7,
        title = "単方向データフローのサンプル",
        route = "UdfSample",
        content = { UdfSample() }
    ),
    Sample(
        section = 7,
        title = "CompositionLocalを定義する例",
        route = "CompositionLocalSample",
        content = { CompositionLocalSample() }
    ),
    Sample(
        section = 7,
        title = "CompositionLocalの値を上書きする例",
        route = "CompositionLocalProviderSample",
        content = { CompositionLocalProviderSample() }
    )
).groupBy { it.section }.toSortedMap()
