package com.gerenciamento_escolar.api.entity.model.Diretor;

import com.gerenciamento_escolar.api.entity.model.Pessoa.Pessoa;
import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "diretor")
@Entity(name = "Diretor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Diretor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Embedded
    private Pessoa pessoa;

    @Embedded
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private CargoDiretoria cargoDiretoria;

    private boolean ativo;

    public Diretor(DadosCadastroDiretor dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.cargoDiretoria = dados.cargoDiretoria();
        this.pessoa = new Pessoa(dados.pessoa());
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizar(DadosAtualizaDiretor dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.cargoDiretoria() != null) {
            this.cargoDiretoria = dados.cargoDiretoria();
        }
        if (dados.pessoa() != null) {
            this.pessoa.atualizarInformacoesPessoa(dados.pessoa());
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoesEndereco(dados.endereco());
        }
    }

    public void inativar() {
        this.ativo = false;
    }

}