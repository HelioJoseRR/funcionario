package com.helio.funcionario.controller

import com.helio.funcionario.dto.FuncionarioDTO
import com.helio.funcionario.service.FuncionarioService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/funcionario")
class FuncionarioController(
    val service: FuncionarioService
) {
    @GetMapping
    fun listarTodos(): List<FuncionarioDTO> =
        service.listarTodos()

    @GetMapping("/busca/id/{id}")
    fun buscarPorId(@PathVariable id: Long): FuncionarioDTO =
        service.buscarPorId(id)

    @GetMapping("/busca/email/{email}")
    fun buscarPorId(@PathVariable email: String): FuncionarioDTO =
        service.buscarPorEmail(email)

    @PostMapping
    fun salvar(@RequestBody dto: FuncionarioDTO): FuncionarioDTO =
        service.salvar(dto)

    @DeleteMapping("/{id}")
    fun apagarPorId(@PathVariable id: Long) : FuncionarioDTO =
        service.apagarPorId(id)
}