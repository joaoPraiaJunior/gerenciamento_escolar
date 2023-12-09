package com.gerenciamento_escolar.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerenciamento_escolar.api.entity.model.disciplina.Disciplina;

public interface DisciplinaRepository  extends JpaRepository<Disciplina, Long>{
    Page<Disciplina> findAllByAtivoTrue(Pageable paginacao);

        @Query("""
            select d.ativo
            from Disciplina d
            where
            d.id = :id
            """)
    Boolean findAtivoById(Long id);
    
}
