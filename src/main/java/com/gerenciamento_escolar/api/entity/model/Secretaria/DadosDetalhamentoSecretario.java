package com.gerenciamento_escolar.api.entity.model.secretaria;

import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.Pessoa;

public record DadosDetalhamentoSecretario(
        Long id,
        String nome,
        CargoSecretario cargo_secretario,
        Pessoa pessoa,
        Endereco endereco
) {

    public DadosDetalhamentoSecretario(Secretario secretario) {
        this(secretario.getId(),
                secretario.getNome(),
                secretario.getCargo_secretario(),
                secretario.getPessoa(),
                secretario.getEndereco());
    }
    
}
