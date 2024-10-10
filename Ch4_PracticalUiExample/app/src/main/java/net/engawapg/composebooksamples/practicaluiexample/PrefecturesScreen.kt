package net.engawapg.composebooksamples.practicaluiexample

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.engawapg.composebooksamples.practicaluiexample.ui.theme.PracticalUiExampleTheme

enum class ListType {
    Column, Grid
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrefecturesScreen(
    prefectures: List<Prefecture> = Prefectures,
    onPrefectureClick: (Prefecture) -> Unit = {},
) {
    var listType by rememberSaveable { mutableStateOf(ListType.Column) }

    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        ListTypeSelectionDialog(
            listType = listType,
            onConfirm = { newListType ->
                listType = newListType
                showDialog = false
            },
            onDismiss = {
                showDialog = false
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("都道府県") },
                actions = {
                    IconButton(onClick = { showDialog = true }) {
                        Icon(
                            painter = painterResource(R.drawable.grid_view),
                            contentDescription = "表示切り替え"
                        )
                    }
                },
            )
        }
    ) { innerPadding ->
        PrefecturesList(
            listType = listType,
            prefectures = prefectures,
            onPrefectureClick = onPrefectureClick,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun PrefecturesList(
    listType: ListType,
    prefectures: List<Prefecture>,
    onPrefectureClick: (Prefecture) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (listType == ListType.Column) {
        PrefecturesColumn(
            prefectures = prefectures,
            onPrefectureClick = onPrefectureClick,
            modifier = modifier
        )
    } else {
        PrefecturesGrid(
            prefectures = prefectures,
            onPrefectureClick = onPrefectureClick,
            modifier = modifier
        )
    }
}

@Composable
private fun PrefecturesColumn(
    prefectures: List<Prefecture>,
    onPrefectureClick: (Prefecture) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(prefectures) { prefecture ->
            ListItem(
                headlineContent = { Text(prefecture.name) },
                leadingContent = {
                    Icon(
                        painterResource(prefecture.imageRes),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.width(80.dp)
                    )
                },
                modifier = Modifier.clickable(
                    onClickLabel = "詳細を確認する"
                ) { onPrefectureClick(prefecture) }
            )
        }
    }
}

@Composable
private fun PrefecturesGrid(
    prefectures: List<Prefecture>,
    onPrefectureClick: (Prefecture) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ) {
        items(prefectures) { prefecture ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClickLabel = "詳細を確認する") {
                        onPrefectureClick(prefecture)
                    }
            ) {
                Icon(
                    painterResource(prefecture.imageRes),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                )
                Text(text = prefecture.name)
            }
        }
    }
}

@Composable
private fun ListTypeSelectionDialog(
    listType: ListType,
    onConfirm: (ListType) -> Unit,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        text = {
            val text = if (listType == ListType.Column) {
                "グリッド表示に変更しますか？"
            } else {
                "リスト表示に変更しますか？"
            }
            Text(text)
        },
        confirmButton = {
            TextButton(
                onClick = {
                    val newListType = if (listType == ListType.Column) {
                        ListType.Grid
                    } else {
                        ListType.Column
                    }
                    onConfirm(newListType)
                }
            ) { Text("はい") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("いいえ") }
        },
        onDismissRequest = onDismiss
    )
}

@Preview
@Composable
fun PrefecturesScreenPreview() {
    PracticalUiExampleTheme {
        PrefecturesScreen(
            prefectures = Prefectures,
            onPrefectureClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrefecturesGridPreview() {
    PracticalUiExampleTheme {
        PrefecturesGrid(
            prefectures = Prefectures,
            onPrefectureClick = {},
        )
    }
}

@Preview
@Composable
fun InformationDialogPreview() {
    PracticalUiExampleTheme {
        ListTypeSelectionDialog(
            listType = ListType.Column,
            onConfirm = {},
            onDismiss = {}
        )
    }
}
