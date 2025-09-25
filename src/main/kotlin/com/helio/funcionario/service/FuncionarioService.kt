package com.helio.funcionario.service

import com.helio.funcionario.dto.ContatoDTO
import com.helio.funcionario.dto.FuncionarioDTO
import com.helio.funcionario.entity.ContatoEntity
import com.helio.funcionario.entity.FuncionarioEntity
import com.helio.funcionario.repository.ContatoRepository
import com.helio.funcionario.repository.FuncionarioRepository
import org.springframework.stereotype.Service

@Service
class FuncionarioService(
    private val funcionarioRepository: FuncionarioRepository,
    private val contatoRepository: ContatoRepository

) {
    fun listarTodos(): List<FuncionarioDTO> =
        funcionarioRepository.findAll().map { it.toDTO() }

    fun buscarPorId(id: Long): FuncionarioDTO {
        val entity = funcionarioRepository.findById(id).orElseThrow { RuntimeException("Nao tem esse funcionario") }
        return entity.toDTO()
    }

    fun buscarPorEmail(email: String): FuncionarioDTO {
        val contato = contatoRepository.findByEmailInst(email)
        val funcionario = contato.funcionario
            ?: throw IllegalStateException("Contato não possui funcionário associado")

        return funcionario.toDTO()
    }

    fun salvar(dto: FuncionarioDTO): FuncionarioDTO {
        val entity = dto.toEntity()

        dto.contato?.let { contatoDTO ->
            val contatoEntity = contatoDTO.toEntity()
            contatoEntity.funcionario = entity // vincula ao funcionário
            entity.contato = contatoEntity
        }

        val saved = funcionarioRepository.save(entity)
        return saved.toDTO()
    }

    fun apagarPorId(id: Long) : FuncionarioDTO {
        val entity = funcionarioRepository.findById(id).orElseThrow { RuntimeException("Nao tem esse funcionario") }
        funcionarioRepository.deleteById(id)
        return entity.toDTO()
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
            contato = this.contato?.toDTO()
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

    private fun ContatoEntity.toDTO(): ContatoDTO =
        ContatoDTO(
            idContato = this.idContato,
            emailInst = this.emailInst,
            emailAlt = this.emailAlt,
            telefone = this.telefone,
            whatsapp = this.whatsapp,
            linkedin = this.linkedin,
            lattes = this.lattes
        )

    private fun ContatoDTO.toEntity(): ContatoEntity =
        ContatoEntity(
            idContato = this.idContato,
            emailInst = this.emailInst,
            emailAlt = this.emailAlt,
            telefone = this.telefone,
            whatsapp = this.whatsapp,
            linkedin = this.linkedin,
            lattes = this.lattes
        )
}