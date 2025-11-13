package com.fatec.media_geral

data class Aluno(
    var nome: String,
    var notas: MutableList<Double> = mutableListOf()
){
    fun calcularMedia(): Double {
        return if (notas.isNotEmpty()) notas.sum() / notas.size else 0.0
    }

    fun avaliarDesempenho(): String {
        val media = calcularMedia()
        return if (media < 6.0) "Reprovado" else if (media <= 9.0) "Aprovado" else "Ótimo Aproveitamento"
    }
}