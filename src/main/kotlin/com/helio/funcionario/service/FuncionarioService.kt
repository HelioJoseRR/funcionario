package com.helio.funcionario.service

import com.helio.funcionario.repository.FuncionarioRepository
import org.springframework.stereotype.Service

@Service
class FuncionarioService(private val repository: FuncionarioRepository) {

}