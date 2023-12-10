package com.gerenciamento_escolar.api.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamento_escolar.api.repository.AlunoRepository;
import com.gerenciamento_escolar.api.repository.DisciplinaRepository;
import com.gerenciamento_escolar.api.repository.MatriculaRepository;
import com.gerenciamento_escolar.api.repository.ProfessorRepository;
import com.gerenciamento_escolar.api.service.validations.ValidacaoException;
import com.gerenciamento_escolar.api.service.validations.matricula.ValidadorMatriculaDeAlunos;

@Service
public class MatricularAluno {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private List<ValidadorMatriculaDeAlunos> validadores;

    public DadosDetalhamentoMatricula matricular(DadosMatriculaAluno dados) {

        System.out.println("DadosMatriculaAluno: " + dados);

        if(!alunoRepository.existsById(dados.id_aluno())) {
            throw new ValidacaoException(("Aluno não encontrado"));
        }

        if(!professorRepository.existsById(dados.id_professor())) {
            throw new ValidacaoException(("Professor não encontrado"));
        }

        if(!disciplinaRepository.existsById(dados.id_disciplina())) {
            throw new ValidacaoException(("Disciplina não encontrada"));
        }

        validadores.forEach(v -> v.validar(dados));

        var aluno = alunoRepository.findById(dados.id_aluno()).get();
        var professor = professorRepository.findById(dados.id_professor()).get();
        var disciplina = disciplinaRepository.findById(dados.id_disciplina()).get();
        var matriculaRealizada = new Matricula(null, aluno, professor, disciplina, dados.data(), null);
        matriculaRepository.save(matriculaRealizada);

        return new DadosDetalhamentoMatricula(matriculaRealizada);
    }

    public void cancelar(DadosCancelamentoMatricula dados) {
        if (!matriculaRepository.existsById(dados.id_matricula())) {
            throw new ValidacaoException("o identificador da matrícula informado não existe!");
        }

        var matriculaCancelada = matriculaRepository.getReferenceById(dados.id_matricula());
        matriculaCancelada.cancelar(dados.motivo());
    }

}

