package com.gerenciamento_escolar.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamento_escolar.api.service.DadosCancelamentoMatricula;
import com.gerenciamento_escolar.api.service.DadosMatriculaAluno;
import com.gerenciamento_escolar.api.service.MatricularAluno;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    private MatricularAluno matricula;

    public MatriculaController(MatricularAluno matricula) {
        this.matricula = matricula;
    }

    @PostMapping
    @Transactional
    public ResponseEntity matricular(@RequestBody @Valid DadosMatriculaAluno dados) {
        var dto = matricula.matricular(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoMatricula dados) {
        matricula.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

}
