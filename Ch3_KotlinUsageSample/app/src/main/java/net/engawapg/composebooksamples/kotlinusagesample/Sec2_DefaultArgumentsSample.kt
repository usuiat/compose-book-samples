package net.engawapg.composebooksamples.kotlinusagesample

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

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
