package com.gerenciamento_escolar.api.entity.model.disciplina;

import com.gerenciamento_escolar.api.entity.model.professor.AulaDisciplina;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroDisciplina(
    @NotNull(message = "A disciplina não pode ser vazia")
    AulaDisciplina disciplina,

    @NotNull(message = "A carga horária não pode ser vazia")
    int carga_horaria
) {
    
}
