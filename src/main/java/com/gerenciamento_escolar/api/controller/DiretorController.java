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

import com.gerenciamento_escolar.api.entity.model.Diretor.DadosAtualizaDiretor;
import com.gerenciamento_escolar.api.entity.model.Diretor.DadosCadastroDiretor;
import com.gerenciamento_escolar.api.entity.model.Diretor.DadosDetalhamentoDiretor;
import com.gerenciamento_escolar.api.entity.model.Diretor.DadosListagemDiretor;
import com.gerenciamento_escolar.api.entity.model.Diretor.Diretor;
import com.gerenciamento_escolar.api.repository.DiretorRepository;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/diretor")
@SecurityRequirement(name = "bearer-key")
public class DiretorController {

    @Autowired
    private DiretorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroDiretor dados, UriComponentsBuilder uriBuilder) {
        var diretor = new Diretor(dados);
        repository.save(diretor);
        var uri = uriBuilder.path("/diretor/{id}").buildAndExpand(diretor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoDiretor(diretor));
    }

    @GetMapping
    public Page<DadosListagemDiretor> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemDiretor::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        Diretor diretor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoDiretor(diretor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@Valid @RequestBody DadosAtualizaDiretor dados) {
        Diretor diretor = repository.getReferenceById(dados.id());
        diretor.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoDiretor(diretor));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        Diretor diretor = repository.getReferenceById(id);
        diretor.inativar();
        return ResponseEntity.noContent().build();
    }

}
