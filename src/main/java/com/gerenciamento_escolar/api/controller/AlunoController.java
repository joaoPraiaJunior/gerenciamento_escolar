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

import com.gerenciamento_escolar.api.entity.model.aluno.Aluno;
import com.gerenciamento_escolar.api.entity.model.aluno.DadosAtualizaAluno;
import com.gerenciamento_escolar.api.entity.model.aluno.DadosCadastroAluno;
import com.gerenciamento_escolar.api.entity.model.aluno.DadosDetalhamentoAluno;
import com.gerenciamento_escolar.api.entity.model.aluno.DadosListagemAluno;
import com.gerenciamento_escolar.api.repository.AlunoRepository;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno")
@SecurityRequirement(name = "bearer-key")
public class AlunoController {
    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAluno dados, UriComponentsBuilder uriBuilder) {
        var aluno = new Aluno(dados);
        repository.save(aluno);
        var uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAluno(aluno));
    }

    @GetMapping
    public Page<DadosListagemAluno> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemAluno::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        Aluno aluno = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@Valid @RequestBody DadosAtualizaAluno dados) {
        Aluno aluno = repository.getReferenceById(dados.id());
        aluno.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        Aluno aluno = repository.getReferenceById(id);
        aluno.inativar();
        return ResponseEntity.noContent().build();
    }
}
