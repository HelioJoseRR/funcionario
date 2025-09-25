package com.helio.funcionario.entity

import com.helio.funcionario.dto.FuncionarioDTO
import jakarta.persistence.*

@Entity
@Table(name = "contato")
data class ContatoEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contato")
    var idContato: Long = 0,
    @Column(name = "email_inst")
    var emailInst: String,
    @Column(name = "email_alt")
    var emailAlt: String,
    @Column(name = "telefone")
    var telefone: String,
    @Column(name = "Whatsapp")
    var whatsapp: String,
    @Column(name = "linkedin")
    var linkedin: String,
    @Column(name = "lattes")
    var lattes: String,
) {
    @OneToOne(cascade = [(CascadeType.ALL)])
    @JoinColumn(name = "func_id", referencedColumnName = "id_func", unique = true)
    var funcionario: FuncionarioEntity? = null
}