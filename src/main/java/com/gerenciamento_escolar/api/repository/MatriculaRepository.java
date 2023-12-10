package com.gerenciamento_escolar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento_escolar.api.service.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
    
}
