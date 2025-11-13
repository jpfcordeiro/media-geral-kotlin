package com.fatec.media_geral

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fatec.media_geral.ui.theme.Media_geralTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Media_geralTheme {
                MediaGeralApp()
            }
        }
    }
}

@Composable
fun MediaGeralApp() {
    var nome by remember {mutableStateOf("")}
    var nota1 by remember { mutableStateOf("") }
    var nota2 by remember { mutableStateOf("") }
    var nota3 by remember { mutableStateOf("") }

    var resultado by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)){
        Text("Cadastro de Aluno", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(value = nome, onValueChange = { nome = it},
            label = { Text("Nome do aluno")}
        )

        OutlinedTextField(
            value = nota1,
            onValueChange = { nota1 = it },
            label = { Text("Nota TP1") }
        )

        OutlinedTextField(
            value = nota2,
            onValueChange = { nota2 = it },
            label = { Text("Nota TP2") }
        )

        OutlinedTextField(
            value = nota3,
            onValueChange = { nota3 = it },
            label = { Text("Nota TP3") }
        )

        Button(onClick = {
            val aluno = Aluno(nome)
            aluno.notas.addAll(
                listOf(
                    nota1.toDoubleOrNull() ?: 0.0,
                    nota2.toDoubleOrNull() ?: 0.0,
                    nota3.toDoubleOrNull() ?: 0.0
                )
            )
            val media = aluno.calcularMedia()
            resultado = "Média: %.2f = ${aluno.avaliarDesempenho()}".format(media)
        }) {
            Text("Calcular Média")
        }

        Text(resultado)

    }

}