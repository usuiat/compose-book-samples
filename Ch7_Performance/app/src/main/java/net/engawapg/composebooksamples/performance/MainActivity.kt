package net.engawapg.composebooksamples.performance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import net.engawapg.composebooksamples.performance.ui.theme.PerformanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PerformanceTheme {
                App(chapter = 7, samples = chapter7Samples)
            }
        }
    }
}

private val chapter7Samples = listOf(
    Sample(
        section = 2,
        title = "再コンポーズが大量に発生する画面の例",
        route = "LayoutInspectorSample",
        content = { LayoutInspectorSample() }
    ),
    Sample(
        section = 2,
        title = "大小の画像を表示する時間を比較する例",
        route = "ProfilerSample",
        content = { ProfilerSample() }
    ),
    Sample(
        section = 3,
        title = "フェーズ変更による改善例",
        route = "PhaseSample",
        content = { PhaseSample() }
    ),
    Sample(
        section = 3,
        title = "derivedStateOfの利用例",
        route = "DerivedStateOfSample",
        content = { DerivedStateOfSample() }
    ),
    Sample(
        section = 3,
        title = "Immutableとkeyの利用例",
        route = "ImmutableSample",
        content = { ImmutableSample() }
    ),
    Sample(
        section = 3,
        title = "Lazyコンポーザブルの利用例",
        route = "LazySample",
        content = { LazySample() }
    ),
).groupBy { it.section }.toSortedMap()
