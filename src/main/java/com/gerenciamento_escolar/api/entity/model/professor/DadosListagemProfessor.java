package com.gerenciamento_escolar.api.entity.model.professor;

public record DadosListagemProfessor(
        Long id,
        String nome,
        String graduacao) {

    public DadosListagemProfessor(Professor professor) {
        this(professor.getId(), professor.getNome(), professor.getGraduacao());
    }
    
}
