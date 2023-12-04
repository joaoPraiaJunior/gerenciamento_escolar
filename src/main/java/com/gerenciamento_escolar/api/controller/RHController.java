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

import com.gerenciamento_escolar.api.entity.model.rh.DadosAtualizaRH;
import com.gerenciamento_escolar.api.entity.model.rh.DadosCadastroRH;
import com.gerenciamento_escolar.api.entity.model.rh.DadosDetalhamentoRH;
import com.gerenciamento_escolar.api.entity.model.rh.DadosListagemRH;
import com.gerenciamento_escolar.api.entity.model.rh.RH;
import com.gerenciamento_escolar.api.repository.RHRepository;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario-rh")
@SecurityRequirement(name = "bearer-key")
public class RHController {

    @Autowired
    private RHRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroRH dados, UriComponentsBuilder uriBuilder) {
        var rh = new RH(dados);
        repository.save(rh);
        var uri = uriBuilder.path("/funcionario-rh/{id}").buildAndExpand(rh.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoRH(rh));
    }

    @GetMapping
    public Page<DadosListagemRH> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemRH::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        RH rh = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoRH(rh));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@Valid @RequestBody DadosAtualizaRH dados) {
        RH rh = repository.getReferenceById(dados.id());
        rh.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoRH(rh));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        RH rh = repository.getReferenceById(id);
        rh.inativar();
        return ResponseEntity.noContent().build();
    }
}
