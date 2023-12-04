package com.gerenciamento_escolar.api.entity.model.professor;

import java.time.LocalDate;

import com.gerenciamento_escolar.api.entity.model.Pessoa.DadosPessoa;
import com.gerenciamento_escolar.api.entity.model.endereco.DadosEndereco;

public record DadosAtualizaProfessor(
    Long id,
    String nome,
    String graduacao,
    String instituicao_formacao,
    LocalDate data_formacao,
    boolean licenciatura,
    String especializacao,
    String mestrado,
    String doutorado,
    AulaDisciplina aulaDisciplina,
    DadosPessoa pessoa,
    DadosEndereco endereco
) {
    
}
