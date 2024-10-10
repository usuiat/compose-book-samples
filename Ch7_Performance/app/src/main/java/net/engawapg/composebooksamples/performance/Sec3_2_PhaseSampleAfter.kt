package net.engawapg.composebooksamples.performance

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun PhaseSample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        ExpandableBox()
    }
}

@Composable
private fun ExpandableBox() {
    var expand by remember { mutableStateOf(false) }
    val boxScale by animateFloatAsState(
        targetValue = if(expand) 2f else 1f,
        animationSpec = spring(stiffness = Spring.StiffnessVeryLow),
        label = "box-scale"
    )
    Box(
        modifier = Modifier
            .size(100.dp)
            // .scale(boxScale) // 改善前
            .graphicsLayer {
                scaleX = boxScale
                scaleY = boxScale
            }
            .background(Color.Red)
            .clickable { expand = !expand }
    )
}
