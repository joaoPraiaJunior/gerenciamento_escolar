package com.gerenciamento_escolar.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gerenciamento_escolar.api.entity.model.professor.DadosAtualizaProfessor;
import com.gerenciamento_escolar.api.entity.model.professor.DadosCadastroProfessor;
import com.gerenciamento_escolar.api.entity.model.professor.DadosDetalhamentoProfessor;
import com.gerenciamento_escolar.api.entity.model.professor.DadosListagemProfessor;
import com.gerenciamento_escolar.api.entity.model.professor.Professor;
import com.gerenciamento_escolar.api.repository.ProfessorRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProfessor dados, UriComponentsBuilder uriBuilder) {
        var professor = new Professor(dados);
        repository.save(professor);
        var uri = uriBuilder.path("/professor/{id}").buildAndExpand(professor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoProfessor(professor));
    }

    @GetMapping
    public Page<DadosListagemProfessor> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemProfessor::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        Professor professor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoProfessor(professor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@Valid @RequestBody DadosAtualizaProfessor dados) {
        Professor professor = repository.getReferenceById(dados.id());
        professor.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoProfessor(professor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        Professor professor = repository.getReferenceById(id);
        professor.inativar();
        return ResponseEntity.noContent().build();
    }

}
