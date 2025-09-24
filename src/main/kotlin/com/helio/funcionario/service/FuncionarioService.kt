package com.helio.funcionario.service

import com.helio.funcionario.dto.FuncionarioDTO
import com.helio.funcionario.entity.FuncionarioEntity
import com.helio.funcionario.repository.FuncionarioRepository
import org.springframework.stereotype.Service

@Service
class FuncionarioService(private val repository: FuncionarioRepository) {
    fun listarTodos(): List<FuncionarioDTO> =
        repository.findAll().map { it.toDTO() }

    fun buscarPorId(id: Long): FuncionarioDTO {
        val entity = repository.findById(id).orElseThrow { RuntimeException("Nao tem esse funcionario") }
        return entity.toDTO()
    }

    fun salvar(dto: FuncionarioDTO): FuncionarioDTO {
        val entity = dto.toEntity()
        val saved = repository.save(entity)
        return saved.toDTO()
    }

    private fun FuncionarioEntity.toDTO(): FuncionarioDTO =
        FuncionarioDTO(
            idFunc = this.idFunc,
            nome = this.nome,
            dataNascimento = this.dataNascimento,
            genero = this.genero,
            pronomes = this.pronomes,
            raca = this.raca,
            estadoCivil = this.estadoCivil,
            dependentesNum = this.dependentesNum,
            ativo = this.ativo,
        )

    private fun FuncionarioDTO.toEntity(): FuncionarioEntity =
        FuncionarioEntity(
            idFunc = this.idFunc,
            nome = this.nome,
            dataNascimento = this.dataNascimento,
            genero = this.genero,
            pronomes = this.pronomes,
            raca = this.raca,
            estadoCivil = this.estadoCivil,
            dependentesNum = this.dependentesNum,
            ativo = this.ativo,
        )
}