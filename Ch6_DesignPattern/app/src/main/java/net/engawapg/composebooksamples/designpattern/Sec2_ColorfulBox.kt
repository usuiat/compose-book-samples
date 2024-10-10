package net.engawapg.composebooksamples.designpattern

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import java.lang.Math.random

@Composable
fun ColorfulBoxSample() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        ColorfulBox(modifier = Modifier.padding(20.dp).size(100.dp))
    }
}

@Composable
fun ColorfulBox(modifier: Modifier = Modifier) {
    val colorfulBoxState = rememberColorfulBoxState(
        initialFillColor = Color.Red,
        initialBorderColor = Color.Black
    )
    Box(
        modifier = modifier
            .background(colorfulBoxState.fillColor)
            .border(width = 5.dp, color = colorfulBoxState.borderColor)
            .clickable { colorfulBoxState.update() }
    )
}

@Composable
fun rememberColorfulBoxState(
    initialFillColor: Color,
    initialBorderColor: Color
): ColorfulBoxState {
    return rememberSaveable(saver = ColorfulBoxState.Saver) {
        ColorfulBoxState(initialFillColor, initialBorderColor)
    }
}

class ColorfulBoxState(initialFillColor: Color, initialBorderColor: Color) {
    var fillColor by mutableStateOf(initialFillColor)
        private set
    var borderColor by mutableStateOf(initialBorderColor)
        private set
    fun update() {
        fillColor = Color(
            red = random().toFloat(),
            green = random().toFloat(),
            blue = random().toFloat()
        )
        borderColor = Color(
            red = random().toFloat(),
            green = random().toFloat(),
            blue = random().toFloat()
        )
    }

    companion object {
        val Saver = mapSaver(
            save = {
                mapOf(
                    "fillColor" to it.fillColor.toArgb(),
                    "borderColor" to it.borderColor.toArgb()
                )
            },
            restore = {
                val fillColor = Color(it["fillColor"] as Int)
                val borderColor = Color(it["borderColor"] as Int)
                ColorfulBoxState(
                    initialFillColor = fillColor,
                    initialBorderColor = borderColor
                )
            }
        )
    }
}
