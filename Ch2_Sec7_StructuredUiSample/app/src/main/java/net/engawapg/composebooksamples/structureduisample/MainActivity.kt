package net.engawapg.composebooksamples.structureduisample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import net.engawapg.composebooksamples.structureduisample.ui.theme.StructuredUiSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StructuredUiSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        val animals = listOf(
                            Animal(R.drawable.dog, "Dog"),
                            Animal(R.drawable.cat, "Cat"),
                            Animal(R.drawable.bird, "Bird"),
                        )
                        AnimalSelection(animals = animals)
                    }
                }
            }
        }
    }
}

@Composable
fun AnimalSelection(animals: List<Animal>) {
    var selectedAnimal by remember { mutableStateOf<Animal?>(null) }
    Column {
        Message(selectedAnimal = selectedAnimal)
        AnimalList(
            animals = animals,
            onAnimalClick = { selectedAnimal = it }
        )
    }
}
@Composable
fun Message(selectedAnimal: Animal?) {
    Column {
        Text(
            text = "Select an image.",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(20.dp)
        )
        if (selectedAnimal != null) {
            Text(
                text = "${selectedAnimal.text} is selected.",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            )
        }
    }
}

@Composable
fun AnimalList(animals: List<Animal>, onAnimalClick: (Animal) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        for (animal in animals) {
            AnimalCard(
                animal = animal,
                onClick = onAnimalClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun AnimalCard(
    animal: Animal,
    onClick: (Animal) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable { onClick(animal) }
    ) {
        Image(
            painter = painterResource(id = animal.resourceId),
            contentDescription = null,
        )
        Text(text = animal.text)
    }
}

data class Animal(
    @DrawableRes val resourceId: Int,
    val text: String,
)
