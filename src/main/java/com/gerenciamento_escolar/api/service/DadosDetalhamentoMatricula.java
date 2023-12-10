package com.gerenciamento_escolar.api.service;

import java.time.LocalDateTime;

public record DadosDetalhamentoMatricula(
        Long id,
        Long id_aluno,
        Long id_professor,
        Long id_disciplina,
        LocalDateTime data) {
    public DadosDetalhamentoMatricula(Matricula matricula) {
        this(matricula.getId(), matricula.getAluno().getId(), matricula.getProfessor().getId(),
                matricula.getDisciplina().getId(), matricula.getData());
    }
}
