package com.gerenciamento_escolar.api.entity.model.diretor;

import com.gerenciamento_escolar.api.entity.model.endereco.Endereco;
import com.gerenciamento_escolar.api.entity.model.pessoa.Pessoa;

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
    private CargoDiretoria cargo_diretoria;

    private boolean ativo;

    public Diretor(DadosCadastroDiretor dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.cargo_diretoria = dados.cargo_diretoria();
        this.pessoa = new Pessoa(dados.pessoa());
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizar(DadosAtualizaDiretor dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.cargo_diretoria() != null) {
            this.cargo_diretoria = dados.cargo_diretoria();
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