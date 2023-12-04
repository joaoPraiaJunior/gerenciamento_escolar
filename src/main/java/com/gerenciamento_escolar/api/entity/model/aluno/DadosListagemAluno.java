package com.gerenciamento_escolar.api.entity.model.aluno;

public record DadosListagemAluno(
        Long id,
        String nome) {

    public DadosListagemAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNome());
    }

}
