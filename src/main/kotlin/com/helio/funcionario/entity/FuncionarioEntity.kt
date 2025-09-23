package com.helio.funcionario.entity

import jakarta.persistence.*

@Entity
class FuncionarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idFunc: Long = 0
    var nome: String = ""
    var dataNascimento: String = ""
    var genero: String = ""
    var pronomes: String = ""
    var raca: String = ""
    var estadoCivil: String = ""
    var dependentesNum: Int = 0
    var ativo: Boolean = true
}