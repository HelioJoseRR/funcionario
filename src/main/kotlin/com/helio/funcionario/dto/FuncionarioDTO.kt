package com.helio.funcionario.dto

data class FuncionarioDTO(
    val id: Long,
    val nome: String,
    val dataNascimento: String,
    val salario: Double,
    val genero: String,
    val pronomes: String,
    val raca: String,
    val estadoCivil: String,
    val dependentesNum: Int,
    val ativo: Boolean,
)
