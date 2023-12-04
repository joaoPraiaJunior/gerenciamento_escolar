package com.gerenciamento_escolar.api.entity.model.professor;

import java.time.LocalDate;

import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.Pessoa;

public record DadosDetalhamentoProfessor(
        Long id,
        String nome,
        String graduacao,
        String instituicao_formacao,
        LocalDate data_formacao,
        boolean licenciatura,
        String especializacao,
        String mestrado,
        String doutorado,
        Pessoa pessoa,
        Endereco endereco,
        AulaDisciplina aula_disciplina) {

    public DadosDetalhamentoProfessor(Professor professor) {
        this(professor.getId(),
                professor.getNome(),
                professor.getGraduacao(),
                professor.getInstituicao_formacao(),
                professor.getData_formacao(),
                professor.isLicenciatura(),
                professor.getEspecializacao(),
                professor.getMestrado(),
                professor.getDoutorado(),
                professor.getPessoa(),
                professor.getEndereco(),
                professor.getAula_disciplina());
    }
}
