package net.engawapg.composebooksamples.practicaluiexample

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.engawapg.composebooksamples.practicaluiexample.ui.theme.PrefecturesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrefectureDetailScreen(
    prefectureName: String,
    onBackClick: () -> Unit,
    onOpenWikiClick: (String) -> Unit,
) {
    val prefecture = Prefectures.find { it.name == prefectureName } ?: return

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(prefecture.name) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(R.drawable.arrow_back),
                            contentDescription = "戻る"
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            PrefectureContent(
                prefecture = prefecture,
                modifier = Modifier.padding(innerPadding),
                onOpenWikiClick = onOpenWikiClick,
            )
        }
    )
}

@Composable
fun PrefectureContent(
    prefecture: Prefecture,
    onOpenWikiClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(prefecture.imageRes),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth()
        )
        PrefectureDataCard(
            prefecture = prefecture,
            modifier = Modifier.padding(12.dp)
        )
        Text(
            text = prefecture.description,
            modifier = Modifier.padding(12.dp)
        )
        TextButton(onClick = { onOpenWikiClick(prefecture.wikiUrl) }) {
            Text("Wikipediaを開く")
        }
    }
}

@Composable
fun PrefectureDataCard(
    prefecture: Prefecture,
    modifier: Modifier = Modifier
) {
    var expand by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
    ) {
        TextButton(onClick = { expand = !expand }) {
            val degree by animateFloatAsState(
                targetValue = if (expand) 45f else 0f,
                label = "ExpandButtonAnimation",
            )
            Icon(
                painter = painterResource(R.drawable.add),
                contentDescription = null,
                modifier = Modifier.rotate(degree)
            )
            Text("データ表示")
        }
        AnimatedVisibility(
            visible = expand,
            enter = expandIn(expandFrom = Alignment.TopStart),
            exit = shrinkOut(shrinkTowards = Alignment.TopStart)
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                PrefectureDataItem(label = "面積", value = prefecture.area)
                PrefectureDataItem(label = "人口", value = prefecture.population)
                PrefectureDataItem(label = "県庁所在地", value = prefecture.capital)
            }
        }
    }
}

@Composable
fun PrefectureDataItem(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.weight(0.3f)
        )
        Text(
            text = value,
            modifier = Modifier.weight(0.7f)
        )
    }
}

@Preview
@Composable
fun PrefectureDetailScreenPreview() {
    PrefecturesTheme {
        PrefectureDetailScreen(
            prefectureName = "北海道",
            onBackClick = {},
            onOpenWikiClick = {},
        )
    }
}

@Preview(widthDp = 300)
@Composable
fun PrefectureDataPreview() {
    PrefecturesTheme {
        Box {
            PrefectureDataCard(
                prefecture = Prefecture(
                    "北海道",
                    "83,456㎢",
                    "525万人",
                    "札幌市",
                    "日本の最北端に位置し、広大な大地と豊かな自然が広がる。農業や酪農が盛んで、新鮮な食材が豊富。冬には雪まつりなど、魅力的なイベントが開催される。",
                    "https://ja.wikipedia.org/wiki/北海道",
                    R.drawable.hokkaido,
                ),
            )
        }
    }
}
