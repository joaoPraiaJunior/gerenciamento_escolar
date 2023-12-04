package com.gerenciamento_escolar.api.entity.model.professor;

import java.time.LocalDate;

import com.gerenciamento_escolar.api.entity.model.Pessoa.Pessoa;
import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;

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
        AulaDisciplina aulaDisciplina) {

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
                professor.getAulaDisciplina());
    }
}
