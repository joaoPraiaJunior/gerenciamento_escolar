package com.gerenciamento_escolar.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento_escolar.api.entity.model.diretor.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long> {
    Page<Diretor> findAllByAtivoTrue(Pageable paginacao);
}
