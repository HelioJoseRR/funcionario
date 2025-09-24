package com.helio.funcionario.controller

import com.helio.funcionario.dto.FuncionarioDTO
import com.helio.funcionario.service.FuncionarioService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/funcionario")
class FuncionarioController(
    val service: FuncionarioService
) {
    @GetMapping
    fun listarTodos(): List<FuncionarioDTO> =
        service.listarTodos()

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): FuncionarioDTO =
        service.buscarPorId(id)

    @PostMapping
    fun salvar(@RequestBody dto: FuncionarioDTO): FuncionarioDTO =
        service.salvar(dto)
}