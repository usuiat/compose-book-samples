package net.engawapg.composebooksamples.layoutsamples

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AlignmentSample1(alignment: Alignment.Horizontal) {
    Column(
        horizontalAlignment = alignment
    ) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.size(70.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.bird),
            modifier = Modifier.size(130.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}

@Composable
fun AlignmentSample2() {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.size(70.dp).align(Alignment.End),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.bird),
            modifier = Modifier.size(130.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AlignmentSample1StartPreview() {
    AlignmentSample1(Alignment.Start)
}

@Preview(showBackground = true)
@Composable
fun AlignmentSample1CenterHorizontallyPreview() {
    AlignmentSample1(Alignment.CenterHorizontally)
}

@Preview(showBackground = true)
@Composable
fun AlignmentSample1EndPreview() {
    AlignmentSample1(Alignment.End)
}

@Preview(showBackground = true)
@Composable
fun AlignmentSample2Preview() {
    AlignmentSample2()
}
