package net.engawapg.composebooksamples.defaultargumentssample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import net.engawapg.composebooksamples.defaultargumentssample.ui.theme.DefaultArgumentsSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DefaultArgumentsSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(32.dp)
                    ) {
                        DialogSample()
                        OutlinedTextFieldSample1()
                        OutlinedTextFieldSample2()
                    }
                }
            }
        }
    }
}

@Composable
fun DialogSample() {
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = { showDialog = false } ) { Text("OK") }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false } ) { Text("Cancel") }
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.info),
                    contentDescription = null
                )
            },
            title = { Text("Sample Dialog") },
            text = { Text("This is a compose sample dialog.") },
            containerColor = Color.White,
            iconContentColor = Color.LightGray,
            titleContentColor = Color.Black,
            textContentColor = Color.Gray,
        )
    }
    Button(onClick = { showDialog = true } ) {
        Text("Show Dialog")
    }
}

@Composable
fun OutlinedTextFieldSample1() {
    OutlinedTextField(
        value = "TextField with default values",
        onValueChange = {}
    )
}

@Composable
fun OutlinedTextFieldSample2() {
    OutlinedTextField(
        value = "Customized TextField",
        onValueChange = {},
        label = { Text("TextField") },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.build),
                contentDescription = null,
            )
        }
    )
}
