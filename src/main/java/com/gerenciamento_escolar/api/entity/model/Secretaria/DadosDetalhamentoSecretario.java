package com.gerenciamento_escolar.api.entity.model.Secretaria;

import com.gerenciamento_escolar.api.entity.model.Pessoa.Pessoa;
import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;

public record DadosDetalhamentoSecretario(
        Long id,
        String nome,
        CargoSecretario cargoSecretario,
        Pessoa pessoa,
        Endereco endereco
) {

    public DadosDetalhamentoSecretario(Secretario secretario) {
        this(secretario.getId(),
                secretario.getNome(),
                secretario.getCargoSecretario(),
                secretario.getPessoa(),
                secretario.getEndereco());
    }
    
}
