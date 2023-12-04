package com.gerenciamento_escolar.api.entity.model.diretor;

import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.Pessoa;

public record DadosDetalhamentoDiretor(
        Long id,
        String nome,
        CargoDiretoria cargo_diretoria,
        Pessoa pessoa,
        Endereco endereco

) {

    public DadosDetalhamentoDiretor(Diretor diretor) {
        this(diretor.getId(),
                diretor.getNome(),
                diretor.getCargo_diretoria(),
                diretor.getPessoa(),
                diretor.getEndereco());
    }
}
