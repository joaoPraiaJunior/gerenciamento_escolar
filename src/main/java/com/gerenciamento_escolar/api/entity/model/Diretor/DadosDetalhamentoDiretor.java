package com.gerenciamento_escolar.api.entity.model.Diretor;

import com.gerenciamento_escolar.api.entity.model.Pessoa.Pessoa;
import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;

public record DadosDetalhamentoDiretor(
        Long id,
        String nome,
        CargoDiretoria cargoDiretoria,
        Pessoa pessoa,
        Endereco endereco

) {

    public DadosDetalhamentoDiretor(Diretor diretor) {
        this(diretor.getId(),
                diretor.getNome(),
                diretor.getCargoDiretoria(),
                diretor.getPessoa(),
                diretor.getEndereco());
    }
}
