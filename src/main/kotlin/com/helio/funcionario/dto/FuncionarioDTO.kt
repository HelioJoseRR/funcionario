package com.helio.funcionario.dto

import java.time.LocalDate

data class FuncionarioDTO(
    val idFunc: Long,
    val nome: String,
    val dataNascimento: LocalDate,
    val genero: String,
    val pronomes: String,
    val raca: String,
    val estadoCivil: String,
    val dependentesNum: Int,
    val ativo: Boolean,
    val contato: ContatoDTO? = null,
)
