package com.gerenciamento_escolar.api.entity.model.secretaria;

import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.DadosPessoa;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaSecretario(
        @NotNull Long id,
        String nome,
        CargoSecretario cargo_secretario,
        DadosPessoa pessoa,
        DadosEndereco endereco) {

}
