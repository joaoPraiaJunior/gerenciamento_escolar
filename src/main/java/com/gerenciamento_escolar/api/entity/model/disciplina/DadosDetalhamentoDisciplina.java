package com.gerenciamento_escolar.api.entity.model.disciplina;

public record DadosDetalhamentoDisciplina(
    Long id,
    String disciplina,
    int carga_horaria
) {
    public DadosDetalhamentoDisciplina(Disciplina disciplina) {
        this(disciplina.getId(),
            disciplina.getDisciplina().toString(),
            disciplina.getCarga_horaria());
    }
}
