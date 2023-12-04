package com.gerenciamento_escolar.api.entity.model.diretor;

import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.DadosPessoa;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaDiretor(
    @NotNull
    Long id,
    String nome,
    CargoDiretoria cargo_diretoria,
    DadosPessoa pessoa,
    DadosEndereco endereco
) {
    
}
