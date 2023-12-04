package com.gerenciamento_escolar.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento_escolar.api.entity.model.RH.RH;

public interface RHRepository  extends JpaRepository<RH, Long>{
    Page<RH> findAllByAtivoTrue(Pageable paginacao);
}
