package com.gerenciamento_escolar.api.entity.model.rh;

import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.Pessoa;

public record DadosDetalhamentoRH(
        Long id,
        String nome,
        CargoRH cargo_rh,
        Pessoa pessoa,
        Endereco endereco) {

    public DadosDetalhamentoRH(RH rh) {
        this(rh.getId(),
                rh.getNome(),
                rh.getCargo_rh(),
                rh.getPessoa(),
                rh.getEndereco());
    }

}
