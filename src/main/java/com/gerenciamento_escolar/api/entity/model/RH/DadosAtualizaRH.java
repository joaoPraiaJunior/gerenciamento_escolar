package com.gerenciamento_escolar.api.entity.model.RH;

import com.gerenciamento_escolar.api.entity.model.Pessoa.DadosPessoa;
import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaRH(
    @NotNull
    Long id,
    String nome,
    CargoRH cargoRH,
    DadosPessoa pessoa,
    DadosEndereco endereco
) {
    
}
