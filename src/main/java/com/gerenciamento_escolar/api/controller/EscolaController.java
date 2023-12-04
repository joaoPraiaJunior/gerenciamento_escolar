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

import com.gerenciamento_escolar.api.entity.model.escola.DadosAtualizaEscola;
import com.gerenciamento_escolar.api.entity.model.escola.DadosCadastroEscola;
import com.gerenciamento_escolar.api.entity.model.escola.DadosDetalhamentoEscola;
import com.gerenciamento_escolar.api.entity.model.escola.DadosListagemEscola;
import com.gerenciamento_escolar.api.entity.model.escola.Escola;
import com.gerenciamento_escolar.api.repository.EscolaRepository;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/escola")
@SecurityRequirement(name = "bearer-key")
public class EscolaController {

    @Autowired
    private EscolaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEscola dados, UriComponentsBuilder uriBuilder) {
        var escola = new Escola(dados);
        repository.save(escola);
        var uri = uriBuilder.path("/escola/{id}").buildAndExpand(escola.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEscola(escola));
    }

    @GetMapping
    public Page<DadosListagemEscola> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemEscola::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var escola = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoEscola(escola));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@Valid @RequestBody DadosAtualizaEscola dados) {
        Escola escola = repository.getReferenceById(dados.id());
        escola.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoEscola(escola));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        Escola escola = repository.getReferenceById(id);
        escola.inativar();
        return ResponseEntity.noContent().build();
    }
}