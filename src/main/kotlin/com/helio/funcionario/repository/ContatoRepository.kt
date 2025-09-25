package com.helio.funcionario.repository

import com.helio.funcionario.entity.ContatoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContatoRepository: JpaRepository<ContatoEntity, Long> {
    fun findByEmailInst(emailInst: String): ContatoEntity
}