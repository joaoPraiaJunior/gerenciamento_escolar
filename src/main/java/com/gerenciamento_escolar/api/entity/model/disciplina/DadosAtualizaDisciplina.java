package com.gerenciamento_escolar.api.entity.model.disciplina;

import com.gerenciamento_escolar.api.entity.model.professor.AulaDisciplina;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaDisciplina(
    @NotNull Long id,
    AulaDisciplina disciplina,
    int carga_horaria) {
    
}
