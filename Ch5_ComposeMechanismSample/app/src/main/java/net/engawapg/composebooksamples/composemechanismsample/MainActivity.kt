package net.engawapg.composebooksamples.composemechanismsample

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
import net.engawapg.composebooksamples.composemechanismsample.ui.theme.ComposeMechanismSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMechanismSampleTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
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
        name = "再コンポーズの起点と範囲およびスキップ",
        content = { RecomposeScopeSample() }
    ),
    Sample(
        name = "再コンポーズによるコンポジションの構造の変更",
        content = { CompositionTreeChangeSample() }
    ),
    Sample(
        name = "Strong Skipping Modeで正しく動作するように修正",
        content = { SkippingModeSample() }
    ),
    Sample(
        name = "rememberにkeyを指定しない場合",
        content = { RememberKeySample1() }
    ),
    Sample(
        name = "rememberにkeyを指定する場合",
        content = { RememberKeySample2() }
    ),
    Sample(
        name = "rememberを使わずにStateを使うとうまく動かない例",
        content = { WithoutRememberSample() }
    ),
    Sample(
        name = "基本的なrememberSaveableの利用例",
        content = { RememberSaveableSample() }
    ),
    Sample(
        name = "Parcelizeアノテーションの利用例",
        content = { ParcelableClassUsageSample() }
    ),
    Sample(
        name = "独自のSaverの実装例",
        content = { SaverUsageSample() }
    ),
    Sample(
        name = "SideEffectの例",
        content = { SideEffectSample() }
    ),
    Sample(
        name = "LaunchedEffectの例",
        content = { LaunchedEffectSample() }
    ),
    Sample(
        name = "DisposableEffectの例",
        content = { DisposableEffectSample() }
    ),
    Sample(
        name = "rememberCoroutineScopeの例",
        content = { CoroutineScopeSample() }
    ),
    Sample(
        name = "rememberUpdatedStateの例",
        content = { RememberUpdatedStateSample() }
    ),
    Sample(
        name = "Composeの作用と副作用の境界",
        content = { DelayedCounter() }
    ),
    Sample(
        name = "単方向データフロー",
        content = { UdfSample() }
    ),
    Sample(
        name = "CompositionLocalの定義",
        content = { CompositionLocalSample() }
    ),
    Sample(
        name = "CompositionLocalの上書き",
        content = { CompositionLocalProviderSample() }
    )
)
