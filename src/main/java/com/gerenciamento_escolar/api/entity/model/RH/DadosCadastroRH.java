package com.gerenciamento_escolar.api.entity.model.rh;

import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.DadosPessoa;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroRH(

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotNull @Valid DadosPessoa pessoa,
        
        @NotNull(message = "O campo 'cargo do colaborador de RH' é obrigatório")
        CargoRH cargo_rh,
        
        @NotNull @Valid DadosEndereco endereco
) {
}
