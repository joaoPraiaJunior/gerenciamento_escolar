package com.gerenciamento_escolar.api.entity.model.professor;

import java.time.LocalDate;

import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.DadosPessoa;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaProfessor(
    @NotNull Long id,
    String nome,
    String graduacao,
    String instituicao_formacao,
    LocalDate data_formacao,
    boolean licenciatura,
    String especializacao,
    String mestrado,
    String doutorado,
    AulaDisciplina aula_disciplina,
    DadosPessoa pessoa,
    DadosEndereco endereco
) {
    
}
