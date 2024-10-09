package net.engawapg.composebooksamples.layoutsamples

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NestedLayoutSample() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
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
        Text("There are three animal pictures")
    }
}

@Preview(showBackground = true)
@Composable
fun NestedLayoutSamplePreview() {
    NestedLayoutSample()
}
