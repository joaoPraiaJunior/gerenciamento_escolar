package com.gerenciamento_escolar.api.service.validations.matricula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gerenciamento_escolar.api.repository.ProfessorRepository;
import com.gerenciamento_escolar.api.service.DadosMatriculaAluno;
import com.gerenciamento_escolar.api.service.validations.ValidacaoException;

@Component
public class ValidadorProfessorAtivo implements ValidadorMatriculaDeAlunos {
    @Autowired
    private ProfessorRepository professorRepository;

    public void validar(DadosMatriculaAluno dados) {
        var professorEstaAtivo = professorRepository.findAtivoById(dados.id_professor());
        if(!professorEstaAtivo) throw new ValidacaoException("A Matrícula não pode ser realizada, pois o professor está inativo.");
    }
}
