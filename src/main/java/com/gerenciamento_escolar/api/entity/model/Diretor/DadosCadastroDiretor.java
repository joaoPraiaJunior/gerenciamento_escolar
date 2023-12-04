package com.gerenciamento_escolar.api.entity.model.diretor;

import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.DadosPessoa;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroDiretor(

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotNull @Valid DadosPessoa pessoa,
        
        @NotNull(message = "O campo 'cargo do diretor' é obrigatório")
        CargoDiretoria cargo_diretoria,
        
        @NotNull @Valid DadosEndereco endereco) {
}
