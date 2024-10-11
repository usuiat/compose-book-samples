package net.engawapg.composebooksamples.composetest

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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

@Composable
fun QuantityPicker(state: QuantityPickerState, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        IconButton(
            enabled = !state.isMinQuantity(),
            onClick = { state.decrease() }
        ) {
            Icon(
                painter = painterResource(R.drawable.minus_circle),
                contentDescription = "Decrease quantity"
            )
        }
        Text(
            text = state.quantity.toString(),
            style = MaterialTheme.typography.titleLarge
        )
        IconButton(
            enabled = !state.isMaxQuantity(),
            onClick = { state.increase() }
        ) {
            Icon(
                painter = painterResource(R.drawable.plus_circle),
                contentDescription = "Increase quantity"
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun QuantityPickerPreviewMinQuantity() {
    val state = QuantityPickerState(
        minQuantity = 0,
        maxQuantity = 99,
        initialQuantity = 0 // 数量が下限
    )
    QuantityPicker(state = state)
}

@Composable
@Preview(showBackground = true)
fun QuantityPickerPreviewMaxQuantity() {
    val state = QuantityPickerState(
        minQuantity = 0,
        maxQuantity = 99,
        initialQuantity = 99 // 数量が上限
    )
    QuantityPicker(state = state)
}

@Composable
@Preview(showBackground = true)
fun QuantityPickerPreview() {
    val state = QuantityPickerState(
        minQuantity = 0,
        maxQuantity = 99,
        initialQuantity = 1 // 下限でも上限でもない
    )
    QuantityPicker(state = state)
}

