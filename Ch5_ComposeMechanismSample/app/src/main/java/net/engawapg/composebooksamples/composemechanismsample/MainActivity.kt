package net.engawapg.composebooksamples.composemechanismsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import net.engawapg.composebooksamples.composemechanismsample.ui.theme.ComposeMechanismSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMechanismSampleTheme {
                App(chapter = 5, samples = chapter5Samples)
            }
        }
    }
}

private val chapter5Samples = listOf(
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
