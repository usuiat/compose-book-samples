package net.engawapg.composebooksamples.composemechanismsample

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

val LocalBorderStroke = compositionLocalOf {
    BorderStroke(width = 1.dp, brush = SolidColor(Color.Black))
}

@Composable
fun CompositionLocalSample() {
    Text(
        text = "Hello",
        modifier = Modifier.border(LocalBorderStroke.current)
    )
}

@Composable
fun CompositionLocalProviderSample() {
    Column {
        Text(
            text = "Hello",
            modifier = Modifier.border(LocalBorderStroke.current)
        )
        CompositionLocalProvider(
            LocalBorderStroke provides BorderStroke(
                width = 5.dp,
                brush = SolidColor(Color.LightGray)
            )
        ) {
            Text(
                text = "Compose",
                modifier = Modifier.border(LocalBorderStroke.current)
            )
        }
    }
}
