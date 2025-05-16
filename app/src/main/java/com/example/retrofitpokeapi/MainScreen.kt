package com.example.retrofitpokeapi

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.retrofitpokeapi.model.Pokemon
import com.example.retrofitpokeapi.network.RetrofitClient
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val scope = rememberCoroutineScope()
    var pokemon by remember { mutableStateOf<Pokemon?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = {
            scope.launch {
                pokemon = RetrofitClient.service.getPokemon("pikachu")
            }
        }) {
            Text("Cargar Pikachu")
        }

        Spacer(modifier = Modifier.height(16.dp))


        pokemon?.let {
            Text("Nombre: ${it.name}")
            Text("Altura: ${it.height}")
            Text("Peso: ${it.weight}")
        }
    }
}
