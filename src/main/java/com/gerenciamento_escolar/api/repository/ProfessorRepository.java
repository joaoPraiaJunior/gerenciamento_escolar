package com.gerenciamento_escolar.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerenciamento_escolar.api.entity.model.professor.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Page<Professor> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select p.ativo
            from Professor p
            where
            p.id = :id
            """)
    Boolean findAtivoById(Long id);
}
