package net.engawapg.composebooksamples.composetest

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

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

