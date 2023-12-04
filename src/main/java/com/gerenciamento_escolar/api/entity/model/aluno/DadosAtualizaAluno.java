package com.gerenciamento_escolar.api.entity.model.aluno;

import com.gerenciamento_escolar.api.entity.model.Pessoa.DadosPessoa;
import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaAluno(
        @NotNull Long id,
        String nome,
        DadosPessoa pessoa,
        DadosEndereco endereco) {
}
