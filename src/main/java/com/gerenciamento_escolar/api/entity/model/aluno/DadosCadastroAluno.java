package com.gerenciamento_escolar.api.entity.model.aluno;

import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.DadosPessoa;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAluno(
    
    @NotBlank(message = "O nome do aluno não pode ser vazio")
    String nome,

    @NotNull
    @Valid
    DadosPessoa pessoa,

    @NotNull @Valid DadosEndereco endereco) {

}
