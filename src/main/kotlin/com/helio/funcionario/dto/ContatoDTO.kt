package com.helio.funcionario.dto

data class ContatoDTO(
    val idContato: Long,
    val emailInst: String,
    val emailAlt: String,
    val telefone: String,
    val whatsapp: String,
    val linkedin: String,
    val lattes: String,
)