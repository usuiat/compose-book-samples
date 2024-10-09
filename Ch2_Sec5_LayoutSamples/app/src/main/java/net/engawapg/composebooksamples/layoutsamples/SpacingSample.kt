package net.engawapg.composebooksamples.layoutsamples

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SpacerSample() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.width(100.dp),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(50.dp))
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.width(100.dp),
            contentDescription = null
        )
    }
}

@Composable
fun PaddingSample() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.width(100.dp).padding(10.dp),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.width(100.dp).padding(10.dp),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SpacerSamplePreview() {
    SpacerSample()
}

@Preview(showBackground = true)
@Composable
fun PaddingSamplePreview() {
    PaddingSample()
}
