package net.engawapg.composebooksamples.designpattern

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import net.engawapg.composebooksamples.designpattern.ui.theme.DesignPatternTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesignPatternTheme {
                App(chapter = 6, samples = chapter6Samples)
            }
        }
    }
}

private val chapter6Samples = listOf(
    Sample(
        section = 1,
        title = "ステートフルなスイッチ",
        route = "MySwitchSample1",
        content = { MySwitchSample1() }
    ),
    Sample(
        section = 1,
        title = "ステートレスなスイッチ",
        route = "MySwitchSample2",
        content = { MySwitchSample2() }
    ),
    Sample(
        section = 1,
        title = "ステートレスなスイッチを利用した通知設定のUI作成例",
        route = "NotificationSettingsSample",
        content = { NotificationSettings() }
    ),
    Sample(
        section = 2,
        title = "クリックするたびに色が変化する矩形の例",
        route = "ColorfulBoxSample",
        content = { ColorfulBoxSample() }
    ),
    Sample(
        section = 3,
        title = "Flowのサンプル",
        route = "FlowSamples",
        content = { FlowSamples() }
    ),
    Sample(
        section = 4,
        title = "TODOリストの実装例",
        route = "ToDoRoute",
        content = { ToDoRoute() }
    ),
).groupBy { it.section }.toSortedMap()
