package com.gerenciamento_escolar.api.service.validations.matricula;

import org.springframework.beans.factory.annotation.Autowired;

import com.gerenciamento_escolar.api.repository.DisciplinaRepository;
import com.gerenciamento_escolar.api.service.DadosMatriculaAluno;
import com.gerenciamento_escolar.api.service.validations.ValidacaoException;

public class ValidadorDisciplinaAtiva implements ValidadorMatriculaDeAlunos{
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public void validar(DadosMatriculaAluno dados) {
        var disciplinaEstaAtiva = disciplinaRepository.findAtivoById(dados.id_disciplina());
        if (!disciplinaEstaAtiva)
            throw new ValidacaoException("A Matrícula não pode ser realizada, pois a disciplina está inativa.");
    }
}
