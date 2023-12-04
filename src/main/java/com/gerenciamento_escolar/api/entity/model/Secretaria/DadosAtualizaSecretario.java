package com.gerenciamento_escolar.api.entity.model.Secretaria;

import com.gerenciamento_escolar.api.entity.model.Pessoa.DadosPessoa;
import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaSecretario(
        @NotNull Long id,
        String nome,
        CargoSecretario cargoSecretario,
        DadosPessoa pessoa,
        DadosEndereco endereco) {

}
