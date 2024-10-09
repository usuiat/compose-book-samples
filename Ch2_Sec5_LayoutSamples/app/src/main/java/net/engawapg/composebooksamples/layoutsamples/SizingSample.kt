package net.engawapg.composebooksamples.layoutsamples

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AbsoluteSizeSample() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.size(size = 100.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.size(width = 150.dp, height = 200.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}

@Composable
fun RelativeToParentSizeSample() {
    Column(modifier = Modifier.width(300.dp)) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.fillMaxWidth(),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.fillMaxWidth(0.7f),
            contentDescription = null
        )
    }
}

@Composable
fun RelativeToSiblingsSample1() {
    Row(modifier = Modifier.width(600.dp)) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.weight(2f),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.weight(1f),
            contentDescription = null
        )
    }
}

@Composable
fun RelativeToSiblingsSample2() {
    Row(modifier = Modifier.width(500.dp)) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.weight(1f),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.width(100.dp),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.bird),
            modifier = Modifier.weight(1f),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AbsoluteSizeSamplePreview() {
    AbsoluteSizeSample()
}

@Preview(showBackground = true)
@Composable
fun RelativeToParentSizeSamplePreview() {
    RelativeToParentSizeSample()
}

@Preview(showBackground = true)
@Composable
fun RelativeToSiblingsSample1Preview() {
    RelativeToSiblingsSample1()
}

@Preview(showBackground = true, widthDp = 500)
@Composable
fun RelativeToSiblingsSample2Preview() {
    RelativeToSiblingsSample2()
}
