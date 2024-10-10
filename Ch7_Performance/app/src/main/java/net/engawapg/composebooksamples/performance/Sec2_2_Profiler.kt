package net.engawapg.composebooksamples.performance

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun ProfilerSample() {
    Column {
        var showImage by remember { mutableStateOf(false) }
        Switch(checked = showImage, onCheckedChange = { showImage = it })
        if (showImage) {
            LargeImage()
            SmallImage()
        }
    }
}

@Composable
fun LargeImage() {
    Image(
        painter = painterResource(R.drawable.sunflower1),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier.fillMaxWidth().aspectRatio(1920/1280f)
    )
}

@Composable
fun SmallImage() {
    Image(
        painter = painterResource(R.drawable.sunflower2),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier.fillMaxWidth().aspectRatio(1920/1280f)
    )
}
