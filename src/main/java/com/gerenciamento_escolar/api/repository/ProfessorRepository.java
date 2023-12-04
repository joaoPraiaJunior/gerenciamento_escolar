package com.gerenciamento_escolar.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento_escolar.api.entity.model.professor.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Page<Professor> findAllByAtivoTrue(Pageable paginacao);
}
