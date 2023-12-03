package com.gerenciamento_escolar.api.entity.model.RH;

import com.gerenciamento_escolar.api.entity.model.Pessoa.Pessoa;
import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;

public record DadosDetalhamentoRH(
        Long id,
        String nome,
        CargoRH cargoRH,
        Pessoa pessoa,
        Endereco endereco) {

    public DadosDetalhamentoRH(RH rh) {
        this(rh.getId(),
                rh.getNome(),
                rh.getCargoRH(),
                rh.getPessoa(),
                rh.getEndereco());
    }

}
