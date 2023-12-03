package com.gerenciamento_escolar.api.entity.model.escola;

import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaEscola(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        String instagram,
        String youtube,
        DadosEndereco endereco
) {
}
