package com.gerenciamento_escolar.api.entity.model.rh;

import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.DadosPessoa;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaRH(
    @NotNull
    Long id,
    String nome,
    CargoRH cargo_rh,
    DadosPessoa pessoa,
    DadosEndereco endereco
) {
    
}
