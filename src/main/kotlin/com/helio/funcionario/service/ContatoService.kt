package com.helio.funcionario.service

import com.helio.funcionario.dto.ContatoDTO
import com.helio.funcionario.entity.ContatoEntity
import com.helio.funcionario.repository.ContatoRepository
import com.helio.funcionario.repository.FuncionarioRepository
import org.springframework.stereotype.Service

@Service
class ContatoService(private val contatoRepository: ContatoRepository) {
}