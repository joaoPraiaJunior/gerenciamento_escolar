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

import com.gerenciamento_escolar.api.entity.model.secretaria.DadosAtualizaSecretario;
import com.gerenciamento_escolar.api.entity.model.secretaria.DadosCadastroSecretario;
import com.gerenciamento_escolar.api.entity.model.secretaria.DadosDetalhamentoSecretario;
import com.gerenciamento_escolar.api.entity.model.secretaria.DadosListagemSecretario;
import com.gerenciamento_escolar.api.entity.model.secretaria.Secretario;
import com.gerenciamento_escolar.api.repository.SecretarioRepository;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario-secretaria")
@SecurityRequirement(name = "bearer-key")
public class SecretarioController {

    @Autowired
    private SecretarioRepository repository;

    @PostMapping
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroSecretario dados,
            UriComponentsBuilder uriBuilder) {
        var rh = new Secretario(dados);
        repository.save(rh);
        var uri = uriBuilder.path("/funcionario-secretaria/{id}").buildAndExpand(rh.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoSecretario(rh));
    }

    @GetMapping
    public Page<DadosListagemSecretario> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemSecretario::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        Secretario secretario = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoSecretario(secretario));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@Valid @RequestBody DadosAtualizaSecretario dados) {
        Secretario secretario = repository.getReferenceById(dados.id());
        secretario.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoSecretario(secretario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        Secretario secretario = repository.getReferenceById(id);
        secretario.inativar();
        return ResponseEntity.noContent().build();
    }

}
