package com.example.ejercicio_funcionalidades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejercicio_funcionalidades.ui.theme.Ejercicio_FuncionalidadesTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio_FuncionalidadesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Composicion(){
    Column (modifier = Modifier
        .fillMaxSize())
    {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(0.5f)
            .background(Color(0xFF8f7cec))
            .padding(10.dp,10.dp,0.dp,0.dp),
            Alignment.TopCenter)

        {
           Icono()
        }
        Box(modifier = Modifier
        .fillMaxWidth()
            .weight(0.5f)
        .background(Color(0xFF7cecdd))
            .padding(10.dp,10.dp,0.dp,0.dp))

        {
            BotonCircularProgress()
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color(0xFF8f7cec))
            .padding(10.dp,10.dp,0.dp,0.dp))
        {
           CampoTextoNoVisible()
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(2f)
            .background(Color(0xFF7cecdd))
            .padding(10.dp,10.dp,0.dp,0.dp))

        {
            SwitchRadioButton()
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(2f)
            .background(Color(0xFF8f7cec))
            .padding(10.dp,10.dp,0.dp,0.dp))
        {
            cambiarImagen()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Composicion()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ejercicio_FuncionalidadesTheme {

    }
}