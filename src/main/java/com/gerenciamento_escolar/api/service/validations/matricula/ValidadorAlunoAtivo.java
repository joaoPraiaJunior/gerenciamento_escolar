package com.gerenciamento_escolar.api.service.validations.matricula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gerenciamento_escolar.api.repository.AlunoRepository;
import com.gerenciamento_escolar.api.service.DadosMatriculaAluno;
import com.gerenciamento_escolar.api.service.validations.ValidacaoException;

@Component
public class ValidadorAlunoAtivo implements ValidadorMatriculaDeAlunos{
    @Autowired
    private AlunoRepository alunoRepository;

    public void validar(DadosMatriculaAluno dados) {
        var alunoEstaAtivo = alunoRepository.findAtivoById(dados.id_aluno());
        if(!alunoEstaAtivo) throw new ValidacaoException("A Matrícula não pode ser realizada, pois o aluno está inativo.");
    }
}
