package com.gerenciamento_escolar.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento_escolar.api.entity.model.Secretaria.Secretario;

public interface SecretarioRepository extends JpaRepository<Secretario, Long>{
    Page<Secretario> findAllByAtivoTrue(Pageable paginacao);
    
}
