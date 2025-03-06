
package com.example.proyecto

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIPrincipal()
        }
    }
}

@Composable
fun UIPrincipal() {
    val contexto = LocalContext.current
    var nombre by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
               horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Nombre:")

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Introduce tu nombre") },
                              modifier = Modifier
                              .padding(vertical = 8.dp)
                              .fillMaxWidth(0.8f)
            )

            Button(
                onClick = { Toast.makeText(contexto, "Hola $nombre!!", Toast.LENGTH_LONG).show() },
                   modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Saludar!")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Previsualizacion() {
    UIPrincipal()
}
