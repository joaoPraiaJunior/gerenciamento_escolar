package com.gerenciamento_escolar.api.entity.model.Diretor;

import com.gerenciamento_escolar.api.entity.model.Pessoa.DadosPessoa;
import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaDiretor(
    @NotNull
    Long id,
    String nome,
    CargoDiretoria cargoDiretoria,
    DadosPessoa pessoa,
    DadosEndereco endereco
) {
    
}
