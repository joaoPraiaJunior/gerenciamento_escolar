package com.gerenciamento_escolar.api.entity.model.disciplina;

public record DadosListagemDisciplina(
    Long id,
    String disciplina,
    int carga_horaria
) {

    public DadosListagemDisciplina(Disciplina disciplina) {
        this(disciplina.getId(),
            disciplina.getDisciplina().toString(),
            disciplina.getCarga_horaria());
    }
    
}
