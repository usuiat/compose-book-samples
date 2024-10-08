package net.engawapg.composebooksamples.imagesamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.engawapg.composebooksamples.imagesamples.ui.theme.Ch2_Sec3_2_ImageSamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ch2_Sec3_2_ImageSamplesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        ImageSample()
//                        ImageSampleFit()
//                        ImageSampleCrop()
//                        ImageSampleFillBounds()
//                        ImageSampleNone()
                    }
                }
            }
        }
    }
}

@Composable
fun ImageSample() {
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = "A dog image"
    )
}

@Composable
fun ImageSampleFit() {
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier.size(300.dp)
    )
}

@Composable
fun ImageSampleCrop() {
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(300.dp)
    )
}

@Composable
fun ImageSampleFillBounds() {
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.size(300.dp)
    )
}

@Composable
fun ImageSampleNone() {
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = null,
        contentScale = ContentScale.None,
        modifier = Modifier.size(300.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ImageSamplePreview() {
    ImageSample()
}

@Preview(showBackground = true)
@Composable
fun ImageSampleFitPreview() {
    ImageSampleFit()
}

@Preview(showBackground = true)
@Composable
fun ImageSampleCropPreview() {
    ImageSampleCrop()
}

@Preview(showBackground = true)
@Composable
fun ImageSampleFillBoundsPreview() {
    ImageSampleFillBounds()
}

@Preview(showBackground = true)
@Composable
fun ImageSampleNonePreview() {
    ImageSampleNone()
}
