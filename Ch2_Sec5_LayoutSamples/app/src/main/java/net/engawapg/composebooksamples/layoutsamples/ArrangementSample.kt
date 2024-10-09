package net.engawapg.composebooksamples.layoutsamples

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ArrangementSample(arrangement: Arrangement.Vertical) {
    Column(
        modifier = Modifier.height(400.dp),
        verticalArrangement = arrangement
    ) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.size(100.dp),
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
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArrangementSampleTopPreview() {
    ArrangementSample(Arrangement.Top)
}

@Preview(showBackground = true)
@Composable
fun ArrangementSampleBottomPreview() {
    ArrangementSample(Arrangement.Bottom)
}

@Preview(showBackground = true)
@Composable
fun ArrangementSampleCenterPreview() {
    ArrangementSample(Arrangement.Center)
}

@Preview(showBackground = true)
@Composable
fun ArrangementSampleSpaceAroundPreview() {
    ArrangementSample(Arrangement.SpaceAround)
}

@Preview(showBackground = true)
@Composable
fun ArrangementSampleSpaceEvenlyPreview() {
    ArrangementSample(Arrangement.SpaceEvenly)
}

@Preview(showBackground = true)
@Composable
fun ArrangementSampleSpaceBetweenPreview() {
    ArrangementSample(Arrangement.SpaceBetween)
}

@Preview(showBackground = true)
@Composable
fun ArrangementSampleSpaceByPreview() {
    ArrangementSample(Arrangement.spacedBy(20.dp))
}
