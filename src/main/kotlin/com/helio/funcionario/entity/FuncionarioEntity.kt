package com.helio.funcionario.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "funcionario")
data class FuncionarioEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_func")
    var idFunc: Long  = 0,
    @Column(name = "nome")
    var nome: String,
    @Column(name = "data_nascimento")
    var dataNascimento: LocalDate,
    @Column(name = "genero")
    var genero: String,
    @Column(name = "pronomes")
    var pronomes: String,
    @Column(name = "raca")
    var raca: String,
    @Column(name = "estado_civil")
    var estadoCivil: String,
    @Column(name = "dependentes_num")
    var dependentesNum: Int,
    @Column(name = "ativo")
    var ativo: Boolean,
) {
    @OneToOne(mappedBy = "funcionario", cascade = [CascadeType.ALL], orphanRemoval = true)
    var contato: ContatoEntity? = null
}