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

import com.gerenciamento_escolar.api.entity.model.disciplina.DadosAtualizaDisciplina;
import com.gerenciamento_escolar.api.entity.model.disciplina.DadosCadastroDisciplina;
import com.gerenciamento_escolar.api.entity.model.disciplina.DadosDetalhamentoDisciplina;
import com.gerenciamento_escolar.api.entity.model.disciplina.DadosListagemDisciplina;
import com.gerenciamento_escolar.api.entity.model.disciplina.Disciplina;
import com.gerenciamento_escolar.api.repository.DisciplinaRepository;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/disciplina")
@SecurityRequirement(name = "bearer-key")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroDisciplina dados,
            UriComponentsBuilder uriBuilder) {
        var disciplina = new Disciplina(dados);
        repository.save(disciplina);
        var uri = uriBuilder.path("/diretor/{id}").buildAndExpand(disciplina.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoDisciplina(disciplina));
    }

    @GetMapping
    public Page<DadosListagemDisciplina> listar(@PageableDefault(size = 10, sort = { "disciplina" }) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemDisciplina::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var disciplina = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoDisciplina(disciplina));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@Valid @RequestBody DadosAtualizaDisciplina dados) {
        Disciplina disciplina = repository.getReferenceById(dados.id());
        disciplina.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoDisciplina(disciplina));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        Disciplina disciplina = repository.getReferenceById(id);
        disciplina.inativar();
        return ResponseEntity.noContent().build();
    }
}
