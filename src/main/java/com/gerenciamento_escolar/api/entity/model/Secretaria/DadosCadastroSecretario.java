package com.gerenciamento_escolar.api.entity.model.secretaria;

import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.DadosPessoa;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroSecretario(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotNull @Valid DadosPessoa pessoa,
        
        @NotNull(message = "O campo 'cargo do Secretário' é obrigatório")
        CargoSecretario cargo_secretario,
        
        @NotNull @Valid DadosEndereco endereco
) {
    
}
