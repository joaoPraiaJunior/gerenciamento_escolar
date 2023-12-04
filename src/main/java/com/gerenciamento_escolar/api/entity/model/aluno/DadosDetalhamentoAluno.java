package com.gerenciamento_escolar.api.entity.model.aluno;

import com.gerenciamento_escolar.api.entity.model.Pessoa.Pessoa;
import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;

public record DadosDetalhamentoAluno(
        Long id,
        String nome,
        Pessoa pessoa,
        Endereco endereco) {

    public DadosDetalhamentoAluno(Aluno aluno) {
        this(aluno.getId(),
                aluno.getNome(),
                aluno.getPessoa(),
                aluno.getEndereco());
    }

}
