package com.gerenciamento_escolar.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento_escolar.api.entity.model.escola.Escola;

public interface EscolaRepository extends JpaRepository<Escola, Long> {
    Page<Escola> findAllByAtivoTrue(Pageable paginacao);
}
