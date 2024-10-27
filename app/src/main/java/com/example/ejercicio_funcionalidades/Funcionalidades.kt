package com.example.ejercicio_funcionalidades


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Icono(){
    Box(){
        Icon(Icons.TwoTone.AccountCircle, contentDescription = null, Modifier.size(80.dp))
    }
}


@Composable
fun BotonCircularProgress(){
    var campoTexto by remember { mutableStateOf("") }
    var cargar by remember{ mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Text(campoTexto, modifier = Modifier.padding(250.dp,10.dp,0.dp,0.dp))

    Button(
        onClick = {campoTexto = "Boton presionado"; cargar=true
            scope.launch{
                delay(5000)
                cargar = false
            }
        }, enabled = !cargar

    ){
        Text("Presionar")
    }

    if(!cargar) return
    CircularProgressIndicator(
        modifier = Modifier.width(30.dp)
            .padding(0.dp,30.dp,0.dp,0.dp),
        color = MaterialTheme.colorScheme.secondary,
        trackColor = MaterialTheme.colorScheme.surfaceVariant,
    )
}

@Composable
fun CampoTextoNoVisible(){
    var textVisible by remember { mutableStateOf(false) }
    var marcada by remember { mutableStateOf(false) }
    var campoTexto by remember { mutableStateOf("")}

    Text(campoTexto, modifier = Modifier.padding(250.dp,10.dp,0.dp,0.dp))

    Button(onClick = {
       campoTexto="Hola Mundo"; textVisible= true
    }) {
        Text("Mostrar campo de texto")

    }
    Row (modifier = Modifier
        .padding(10.dp,45.dp,0.dp,0.dp),
        verticalAlignment = Alignment.CenterVertically){
        Text("Activar")
        Checkbox(checked = marcada, onCheckedChange = {marcada = it; campoTexto = "CheckBox Activo"})
}

}


@Composable
fun SwitchRadioButton() {
    var mostrarRadioButtons by remember { mutableStateOf(false) }
    var opcionselec by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = mostrarRadioButtons,
                onCheckedChange = { mostrarRadioButtons = it }
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text("Mostrar opciones")
        }


        if (mostrarRadioButtons) {

            val options = listOf("Opción 1", "Opción 2", "Opción 3")

            options.forEach { option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    RadioButton(
                        selected = opcionselec == option,
                        onClick = { opcionselec = option }
                    )
                    Text(
                        text = option,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
            Text(
                text = "Opción seleccionada: $opcionselec",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun cambiarImagen(){

    val images = listOf(
        painterResource(id = R.drawable.imagen1),
        painterResource(id = R.drawable.imagen2),
        painterResource(id = R.drawable.imagen3)
    )

    var currentIndex by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        Arrangement.Center,
        ) {

        Image(
            painter = images[currentIndex],
            contentDescription = "Imagen actual",
            modifier = Modifier.size(200.dp)
        )

        Button(onClick = {

            currentIndex = (currentIndex + 1) % images.size
        }, modifier = Modifier.padding(20.dp)) {
            Text("Cambiar Imagen")
        }
    }
}










