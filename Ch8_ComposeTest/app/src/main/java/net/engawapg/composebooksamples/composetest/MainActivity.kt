package net.engawapg.composebooksamples.composetest

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.engawapg.composebooksamples.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    OrderCard(modifier = Modifier.padding(innerPadding).width(250.dp))
                }
            }
        }
    }
}

@Composable
fun OrderCard(modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.shoes),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "メンズスニーカー（白）")
        Text("¥5,980")

        val state = remember {
            QuantityPickerState(minQuantity = 1, maxQuantity = 3, initialQuantity = 1)
        }
        QuantityPicker(state = state, modifier = Modifier.align(Alignment.End))

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = {}
        ) {
            Text("カートに入れる")
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(fontScale = 2.0f)
@Composable
fun OrderCardPreview() {
    ComposeTestTheme {
        OrderCard(modifier = Modifier.width(250.dp))
    }
}