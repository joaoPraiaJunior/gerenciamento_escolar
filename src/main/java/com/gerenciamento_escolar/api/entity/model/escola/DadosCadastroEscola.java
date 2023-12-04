package com.gerenciamento_escolar.api.entity.model.escola;

import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEscola(
        @NotBlank(message = "O nome da escola é obrigatório")
        String nome,

        @NotBlank(message = "O CNPJ é obrigatório")
        @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter 14 dígitos")
        String cnpj,

        @NotBlank(message = "O email é obrigatório")
        @Pattern(regexp = "\\w+@\\w+\\.\\w{2,3}(\\.\\w{2})?", message = "O email deve ser válido")
        String email,

        @NotBlank(message = "O telefone é obrigatório")
        String telefone,

        String instagram,

        String youtube,

        @NotNull @Valid DadosEndereco endereco) {
}
