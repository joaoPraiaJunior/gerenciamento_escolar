package com.gerenciamento_escolar.api.entity.model.professor;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.DadosPessoa;

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

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate data_formacao,

    @NotNull(message = "O curso de licenciatura do professor não pode ser vazio")
    boolean licenciatura,

    String especializacao,

    String mestrado,

    String doutorado,

    @NotNull(message = "A aula/disciplina do professor não pode ser vazio")
    AulaDisciplina aula_disciplina,

    @NotNull @Valid DadosPessoa pessoa,

    @NotNull @Valid DadosEndereco endereco
) {
    
}
