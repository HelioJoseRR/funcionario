package com.helio.funcionario.repository

import com.helio.funcionario.entity.FuncionarioEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FuncionarioRepository: JpaRepository<FuncionarioEntity, Long> {
}