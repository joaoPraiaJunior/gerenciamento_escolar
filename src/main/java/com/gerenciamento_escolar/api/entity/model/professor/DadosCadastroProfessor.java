package com.gerenciamento_escolar.api.entity.model.professor;

import java.time.LocalDate;

import com.gerenciamento_escolar.api.entity.model.Pessoa.DadosPessoa;
import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProfessor(

    @NotBlank(message = "O nome do professor não pode ser vazio")
    String nome,

    @NotBlank(message = "A graduação do professor não pode ser vazio")
    String graduacao,

    @NotBlank(message = "A instituição de formação do professor não pode ser vazio")
    String instituicao_formacao,

    @NotBlank(message = "A data de formação do professor não pode ser vazio")
    LocalDate data_formacao,

    @NotBlank(message = "A licenciatura do professor não pode ser vazio")
    boolean licenciatura,

    String especializacao,

    String mestrado,

    String doutorado,

    @NotBlank(message = "A aula/disciplina do professor não pode ser vazio")
    AulaDisciplina aulaDisciplina,

    @NotNull
    @Valid
    DadosPessoa pessoa,

    @NotNull @Valid DadosEndereco endereco
) {
    
}
