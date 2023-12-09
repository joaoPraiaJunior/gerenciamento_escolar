package com.gerenciamento_escolar.api.service;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;

public record DadosMatriculaAluno(

    @NotNull
    Long id_aluno,

    @NotNull
    Long id_professor,

    @NotNull
    Long id_disciplina,

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime data
) {
    
}
