package com.gerenciamento_escolar.api.entity.model.pessoa;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosPessoa(

        String nome_mae,
        
        String nome_pai,

        @NotBlank(message = "Data de nascimento é obrigatória")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate data_nascimento,

        @NotBlank(message = "A nacionalidade é obrigatória")
        String nacionalidade,

        @NotBlank(message = "A naturalidade é obrigatória")
        String naturalidade,

        @NotBlank(message = "O gênero é obrigatório")
        @Pattern(regexp = "^[M|F]{1}$", message ="Pode ser M ou F")
        String genero,

        @NotBlank(message = "O estado civil é obrigatório")
        String estado_civil,

        @NotBlank(message = "O CPF é obrigatório")
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}", message = "O CPF deve ser válido")
        String cpf,

        @NotBlank(message = "O RG é obrigatório")
        @Pattern(regexp = "\\d{2}\\.?\\d{3}\\.?\\d{3}\\-?\\d{1}", message = "O RG deve ser válido")
        String rg,

        @NotBlank(message = "O órgão emissor é obrigatório")
        String orgao_emissor,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate data_emissao,

        @NotBlank(message = "O email é obrigatório")
        @Pattern(regexp = "\\w+@\\w+\\.\\w{2,3}(\\.\\w{2})?", message = "O email deve ser válido")
        String email,

        @NotBlank(message = "O telefone é obrigatório")
        String telefone
) {
}
